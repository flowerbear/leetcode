select e.name As Employee
from employee e, employee m
where e.managerId = m.id and e.salary > m.salary;