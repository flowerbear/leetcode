Order Two Columns Independently

Table: Data

+-------------+------+
| Column Name | Type |
+-------------+------+
| first_col   | int  |
| second_col  | int  |
+-------------+------+
There is no primary key for this table and it may contain duplicates.


Write an SQL query to independently:

order first_col in ascending order.
order second_col in descending order.
The query result format is in the following example.



Example 1:

Input:
Data table:
+-----------+------------+
| first_col | second_col |
+-----------+------------+
| 4         | 2          |
| 2         | 3          |
| 3         | 1          |
| 1         | 4          |
+-----------+------------+
Output:
+-----------+------------+
| first_col | second_col |
+-----------+------------+
| 1         | 4          |
| 2         | 3          |
| 3         | 2          |
| 4         | 1          |
+-----------+------------+


select a.first_col, b.second_col
from (
select first_col, row_number() over (order by first_col asc) rnk
from data
) a inner join (
select second_col, row_number() over (order by second_col desc) rnk
from data
) b on a.rnk = b.rnk;