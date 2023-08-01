with cte as (
select country, created_at, number_of_comments
from fb_comments_count c join fb_active_users u on c.user_id = u.user_id
where c.created_at between '2019-12-01' and '2020-01-31'),
dec_ranking as (
select country, sum(number_of_comments), dense_rank() over (order by sum(number_of_comments) desc) as dec_rnk
from cte
where created_at between '2019-12-01' and '2019-12-31'
group by country),
jan_ranking as (
select country, sum(number_of_comments), dense_rank() over (order by sum(number_of_comments) desc) as jan_rnk
from cte
where created_at between '2020-01-01' and '2020-01-31'
group by country)

select j.country
from jan_ranking j left join dec_ranking d on d.country = j.country
where dec_rnk > jan_rnk or d.country is null;