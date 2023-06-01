Table: Stadium

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| visit_date    | date    |
| people        | int     |
+---------------+---------+
visit_date is the primary key for this table.
Each row of this table contains the visit date and visit id to the stadium with the number of people during the visit.
No two rows will have the same visit_date, and as the id increases, the dates increase as well.


Write an SQL query to display the records with three or more rows with consecutive id's, and the number of people is greater than or equal to 100 for each.

Return the result table ordered by visit_date in ascending order.

The query result format is in the following example.



Example 1:

Input:
Stadium table:
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 1    | 2017-01-01 | 10        |
| 2    | 2017-01-02 | 109       |
| 3    | 2017-01-03 | 150       |
| 4    | 2017-01-04 | 99        |
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-09 | 188       |
+------+------------+-----------+
Output:
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-09 | 188       |
+------+------------+-----------+
Explanation:
The four rows with ids 5, 6, 7, and 8 have consecutive ids and each of them has >= 100 people attended. Note that row 8 was included even though the visit_date was not the next day after row 7.
The rows with ids 2 and 3 are not included because we need at least three consecutive ids.

select id, visit_date, people
from (
select id, visit_date, people, count(*) over (partition by rn) cnt
from (
SELECT id, visit_date, people, id - row_number() over (order by id) rn
FROM Stadium
WHERE people >= 100) a) b
WHERE b.cnt >= 3;


SELECT DISTINCT s1.*
FROM stadium AS s1, stadium AS s2, stadium AS s3
WHERE s1.people >= 100 AND s2.people >= 100 AND s3.people >= 100
AND
(
    (s2.id = s1.id + 1 AND s3.id = s2.id + 1 AND s3.id = s1.id + 2) -- s1, s2, s3
    OR
    (s1.id = s2.id + 1 AND s3.id = s1.id + 1 AND s3.id = s2.id + 2) -- s2, s1, s3
    OR
    (s3.id = s2.id + 1 AND s1.id = s3.id + 1 AND s1.id = s2.id + 2) -- s2, s3, s1
)
ORDER BY s1.id
;


select distinct s1.* from stadium s1, stadium s2, stadium s3
    where ((s1.id = s2.id - 1 and s2.id = s3.id - 1) or
           (s1.id = s2.id + 1 and s1.id = s3.id - 1) or
           (s1.id = s3.id + 1 and s2.id = s3.id - 1))
        and (s1.people >= 100 and s2.people >= 100 and s3.people >= 100)
    order by s1.id;