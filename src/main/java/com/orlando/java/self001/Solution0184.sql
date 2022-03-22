select d.name AS 'Department',
       e.name AS 'Employee',
       e.salary
from (select name, salary, departmentid, rank() over (partition by departmentid order by salary DESC) salary_rank from employee) e,
     department d
where e.departmentid=d.id and e.salary_rank=1;