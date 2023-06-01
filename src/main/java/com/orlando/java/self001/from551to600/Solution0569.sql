The Employee table holds all employees. The employee table has three columns: Employee Id, Company Name, and Salary.

+-----+------------+--------+
|Id   | Company    | Salary |
+-----+------------+--------+
|1    | A          | 2341   |
|2    | A          | 341    |
|3    | A          | 15     |
|4    | A          | 15314  |
|5    | A          | 451    |
|6    | A          | 513    |
|7    | B          | 15     |
|8    | B          | 13     |
|9    | B          | 1154   |
|10   | B          | 1345   |
|11   | B          | 1221   |
|12   | B          | 234    |
|13   | C          | 2345   |
|14   | C          | 2645   |
|15   | C          | 2645   |
|16   | C          | 2652   |
|17   | C          | 65     |
+-----+------------+--------+
Write a SQL query to find the median salary of each company. Bonus points if you can solve it without using any built-in SQL functions.

+-----+------------+--------+
|Id   | Company    | Salary |
+-----+------------+--------+
|5    | A          | 451    |
|6    | A          | 513    |
|12   | B          | 234    |
|9    | B          | 1154   |
|14   | C          | 2645   |
|14   | C          | 2645   |
+-----+------------+--------+

select e1.id, e1.Company, e1.Salary
    from Employee e1, Employee e2
    where e1.Company = e2.Company
    group by e1.id, e1.Company
    having sum(
        case when e1.Salary = e2.Salary then 1 else 0 end
    ) >= abs(sum(sign(e1.Salary - e2.Salary)))
    order by e1.Id;

WITH cte AS (
SELECT
	id,
	company,
	Salary,
	ROW_NUMBER() OVER(PARTITION BY company ORDER BY Salary) as rn,
	COUNT(*) OVER(PARTITION BY company ) as rc
FROM Employee
)
SELECT id, company, salary
FROM cte

SELECT Id, company, salary
FROM cte

WHERE rn IN ( (rc+1 ) DIV 2 , (rc+2) DIV 2 )
or
WHERE (cnt/2) <= rnum AND rnum<= (cnt/2) + 1
ORDER BY company, salary