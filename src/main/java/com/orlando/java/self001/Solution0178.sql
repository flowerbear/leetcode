select score, my_rank as 'rank'
from (
select score, DENSE_RANK() over (order by score DESC) my_rank
from scores) a
order by my_rank;