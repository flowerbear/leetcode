select distinct l1.num as ConsecutiveNums
from logs l1, logs l2, logs l3
where l1.id = l2.id -1 and l2.id = l3.id -1
and l1.num = l2.num and l2.num=l3.num;

SELECT distinct num AS ConsecutiveNums
FROM (
SELECT num, id + 1 - rank() OVER (PARTITION BY num ORDER BY id) 'id'
FROM Logs) l
GROUP BY num, id
HAVING COUNT(1) >= 3;