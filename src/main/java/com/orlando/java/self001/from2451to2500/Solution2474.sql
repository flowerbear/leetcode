Customers With Strictly Increasing Purchases

Table: Orders

+--------------+------+
| Column Name  | Type |
+--------------+------+
| order_id     | int  |
| customer_id  | int  |
| order_date   | date |
| price        | int  |
+--------------+------+
order_id is the primary key for this table.
Each row contains the id of an order, the id of customer that ordered it, the date of the order, and its price.


Write an SQL query to report the IDs of the customers with the total purchases strictly increasing yearly.

The total purchases of a customer in one year is the sum of the prices of their orders in that year. If for some year the customer did not make any order, we consider the total purchases 0.
The first year to consider for each customer is the year of their first order.
The last year to consider for each customer is the year of their last order.
Return the result table in any order.

The query result format is in the following example.



Example 1:

Input:
Orders table:
+----------+-------------+------------+-------+
| order_id | customer_id | order_date | price |
+----------+-------------+------------+-------+
| 1        | 1           | 2019-07-01 | 1100  |
| 2        | 1           | 2019-11-01 | 1200  |
| 3        | 1           | 2020-05-26 | 3000  |
| 4        | 1           | 2021-08-31 | 3100  |
| 5        | 1           | 2022-12-07 | 4700  |
| 6        | 2           | 2015-01-01 | 700   |
| 7        | 2           | 2017-11-07 | 1000  |
| 8        | 3           | 2017-01-01 | 900   |
| 9        | 3           | 2018-11-07 | 900   |
+----------+-------------+------------+-------+
Output:
+-------------+
| customer_id |
+-------------+
| 1           |
+-------------+
Explanation:
Customer 1: The first year is 2019 and the last year is 2022
  - 2019: 1100 + 1200 = 2300
  - 2020: 3000
  - 2021: 3100
  - 2022: 4700
  We can see that the total purchases are strictly increasing yearly, so we include customer 1 in the answer.

Customer 2: The first year is 2015 and the last year is 2017
  - 2015: 700
  - 2016: 0
  - 2017: 1000
  We do not include customer 2 in the answer because the total purchases are not strictly increasing. Note that customer 2 did not make any purchases in 2016.

Customer 3: The first year is 2017, and the last year is 2018
  - 2017: 900
  - 2018: 900
  We can see that the total purchases are strictly increasing yearly, so we include customer 1 in the answer.

with cte as (
  select customer_id, year(order_date) as order_year, sum(price) as prices
  from orders
  group by customer_id, order_year
),
cte1 as (
  select customer_id, order_year, prices,DENSE_RANK() over (partition by customer_id order by prices) as rn
  from cte
),
cte2 as (
  select distinct customer_id, order_year - rn as newline
  from cte1
)
select customer_id
from cte2
group by customer_id
having count(newline) = 1;

WITH year_cte AS (
    SELECT  customer_id,
            YEAR(order_date) AS year,
            SUM(price) AS total
    FROM Orders
    GROUP BY customer_id, year
    ORDER BY NULL
)

SELECT a.customer_id
FROM year_cte a
     LEFT JOIN year_cte b
     ON b.customer_id = a.customer_id AND b.year = a.year + 1
GROUP BY a.customer_id
HAVING SUM(a.total >= IFNULL(b.total, 0)) = 1
ORDER BY NULL;


WITH annual_purchases AS (
    SELECT customer_id,
           YEAR(order_date) AS year,
           SUM(price) AS total_purchases
    FROM Orders
    GROUP BY customer_id, YEAR(order_date)
)
SELECT customer_id
FROM (
    SELECT customer_id,
           year - LAG(year) OVER w AS year_diff,
           total_purchases - LAG(total_purchases) OVER w AS purchases_diff
    FROM annual_purchases
    WINDOW w AS (PARTITION BY customer_id ORDER BY year)
) t
GROUP BY customer_id
HAVING COUNT(customer_id) = 1
       OR (SUM(year_diff = 1) = COUNT(year_diff) AND SUM(purchases_diff > 0) = COUNT(purchase_diff));