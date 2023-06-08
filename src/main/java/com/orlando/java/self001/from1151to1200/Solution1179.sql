Table: Department

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| revenue     | int     |
| month       | varchar |
+-------------+---------+
(id, month) is the primary key of this table.
The table has information about the revenue of each department per month.
The month has values in ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"].


Write an SQL query to reformat the table such that there is a department id column and a revenue column for each month.

Return the result table in any order.

The query result format is in the following example.



Example 1:

Input:
Department table:
+------+---------+-------+
| id   | revenue | month |
+------+---------+-------+
| 1    | 8000    | Jan   |
| 2    | 9000    | Jan   |
| 3    | 10000   | Feb   |
| 1    | 7000    | Feb   |
| 1    | 6000    | Mar   |
+------+---------+-------+
Output:
+------+-------------+-------------+-------------+-----+-------------+
| id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
+------+-------------+-------------+-------------+-----+-------------+
| 1    | 8000        | 7000        | 6000        | ... | null        |
| 2    | 9000        | null        | null        | ... | null        |
| 3    | null        | 10000       | null        | ... | null        |
+------+-------------+-------------+-------------+-----+-------------+
Explanation: The revenue from Apr to Dec is null.
Note that the result table has 13 columns (1 for the department id + 12 for the months).

select id,
    sum(case `month` when 'Jan' then revenue end) as Jan_Revenue,
    sum(case `month` when 'Feb' then revenue end) as Feb_Revenue,
    sum(case `month` when 'Mar' then revenue end) as Mar_Revenue,
    sum(case `month` when 'Apr' then revenue end) as Apr_Revenue,
    sum(case `month` when 'May' then revenue end) as May_Revenue,
    sum(case `month` when 'Jun' then revenue end) as Jun_Revenue,
    sum(case `month` when 'Jul' then revenue end) as Jul_Revenue,
    sum(case `month` when 'Aug' then revenue end) as Aug_Revenue,
    sum(case `month` when 'Sep' then revenue end) as Sep_Revenue,
    sum(case `month` when 'Oct' then revenue end) as Oct_Revenue,
    sum(case `month` when 'Nov' then revenue end) as Nov_Revenue,
    sum(case `month` when 'Dec' then revenue end) as Dec_Revenue
from Department group by id;