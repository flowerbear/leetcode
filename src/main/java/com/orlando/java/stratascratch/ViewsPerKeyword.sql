with recursive num (n) as
(
select 1
union all
select n+1 from num where n<=20
),
keywords_data as
(
select replace(replace(replace(post_keywords, "[", ""), "]", ""), "#", "") as post_keyword,viewer_id
from facebook_posts
left join facebook_post_views on facebook_posts.post_id = facebook_post_views.post_id
)
select substring_index(substring_index(post_keyword, ",", n), ",", -1) as keyword, sum(case when viewer_id is not Null then 1 else 0 end) as total_views
from keywords_data
join num on n<=char_length(post_keyword) - char_length(replace(post_keyword, ",", "")) + 1
group by keyword
order by total_views desc