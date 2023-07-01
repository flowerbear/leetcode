The Number of Seniors and Juniors to Join the Company

Table: Candidates

+-------------+------+
| Column Name | Type |
+-------------+------+
| employee_id | int  |
| experience  | enum |
| salary      | int  |
+-------------+------+
employee_id is the primary key column for this table.
experience is an enum with one of the values ('Senior', 'Junior').
Each row of this table indicates the id of a candidate, their monthly salary, and their experience.


A company wants to hire new employees. The budget of the company for the salaries is $70000. The company's criteria for hiring are:

Hiring the largest number of seniors.
After hiring the maximum number of seniors, use the remaining budget to hire the largest number of juniors.
Write an SQL query to find the number of seniors and juniors hired under the mentioned criteria.

Return the result table in any order.

The query result format is in the following example.



Example 1:

Input:
Candidates table:
+-------------+------------+--------+
| employee_id | experience | salary |
+-------------+------------+--------+
| 1           | Junior     | 10000  |
| 9           | Junior     | 10000  |
| 2           | Senior     | 20000  |
| 11          | Senior     | 20000  |
| 13          | Senior     | 50000  |
| 4           | Junior     | 40000  |
+-------------+------------+--------+
Output:
+------------+---------------------+
| experience | accepted_candidates |
+------------+---------------------+
| Senior     | 2                   |
| Junior     | 2                   |
+------------+---------------------+
Explanation:
We can hire 2 seniors with IDs (2, 11). Since the budget is $70000 and the sum of their salaries is $40000, we still have $30000 but they are not enough to hire the senior candidate with ID 13.
We can hire 2 juniors with IDs (1, 9). Since the remaining budget is $30000 and the sum of their salaries is $20000, we still have $10000 but they are not enough to hire the junior candidate with ID 4.
Example 2:

Input:
Candidates table:
+-------------+------------+--------+
| employee_id | experience | salary |
+-------------+------------+--------+
| 1           | Junior     | 10000  |
| 9           | Junior     | 10000  |
| 2           | Senior     | 80000  |
| 11          | Senior     | 80000  |
| 13          | Senior     | 80000  |
| 4           | Junior     | 40000  |
+-------------+------------+--------+
Output:
+------------+---------------------+
| experience | accepted_candidates |
+------------+---------------------+
| Senior     | 0                   |
| Junior     | 3                   |
+------------+---------------------+
Explanation:
We cannot hire any seniors with the current budget as we need at least $80000 to hire one senior.
We can hire all three juniors with the remaining budget.

WITH senior_cte AS
(
    SELECT  employee_id,
            salary_accu
    FROM
    (
        SELECT  employee_id,
                SUM(salary)  OVER(ORDER BY salary, employee_id) AS salary_accu
        FROM    candidates
        WHERE   experience = 'Senior'
    ) a
    WHERE salary_accu <= 70000
),
senior_max_cte AS
(
    SELECT IFNULL(MAX(salary_accu), 0) AS salary
    FROM senior_cte
),
junior_cte AS
(
    SELECT  employee_id
    FROM
    (
        SELECT  employee_id,
                SUM(salary)  OVER(ORDER BY salary, employee_id) AS salary_accu
        FROM    candidates
        WHERE   experience = 'Junior'
    ) a
    WHERE salary_accu + (SELECT salary FROM senior_max_cte) <= 70000
)

SELECT 'Senior' AS experience, COUNT(1) AS accepted_candidates FROM senior_cte
UNION ALL
SELECT 'Junior' AS experience, COUNT(1) AS accepted_candidates FROM junior_cte;


WITH seniors AS (
    SELECT *
    FROM (
        SELECT employee_id,
               70000 - SUM(salary) OVER (ORDER BY salary) AS s_remainings
        FROM Candidates
        WHERE experience = 'Senior'
    ) s
    WHERE s_remainings >= 0
), juniors AS (
    SELECT *
    FROM (
        SELECT employee_id,
               IFNULL((SELECT MIN(s_remainings) FROM seniors), 70000) - SUM(salary) OVER (ORDER BY salary) AS j_remainings
        FROM Candidates
        WHERE experience = 'Junior'
    ) j
    WHERE j_remainings >= 0
)
SELECT 'Senior' AS experience,
       COUNT(employee_id) AS accepted_candidates
FROM seniors
UNION
SELECT 'Junior',
       COUNT(employee_id)
FROM juniors;