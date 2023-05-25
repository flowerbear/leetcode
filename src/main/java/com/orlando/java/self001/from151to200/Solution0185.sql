SELECT
    d.Name AS 'Department', e1.Name AS 'Employee', e1.Salary
FROM
    Employee e1
        JOIN
    Department d ON e1.DepartmentId = d.Id
WHERE
    3 > (SELECT
            COUNT(DISTINCT e2.Salary)
        FROM
            Employee e2
        WHERE
            e2.Salary > e1.Salary
                AND e1.DepartmentId = e2.DepartmentId
        )
;



select dep_name as Department, emp_name as Employee, salary
from (
select e.name as emp_name, d.name as dep_name, e.salary, DENSE_RANK() OVER(PARTITION BY d.name order by e.salary desc) as rnk
from employee e inner join Department d on e.departmentId = d.id) t
where t.rnk<=3