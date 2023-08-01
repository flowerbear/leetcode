with cte as(
select * from fb_eu_energy
union all
select * from fb_na_energy
union all
select * from fb_asia_energy)

select distinct date,
sum(consumption)over(order by date asc) as tota,
round((sum(consumption) over (order by date asc)/(select sum(consumption)from cte))*100) as pec
from cte