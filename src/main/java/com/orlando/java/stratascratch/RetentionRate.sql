select account_id
, ROUND(sum(jan_retention)/sum(dec_retention)) as retention_rate
from
(select *,
case when date_format(last_date,'%Y-%m') > '2020-12' then 1 else 0 end dec_retention
,case when date_format(last_date,'%Y-%m') > '2021-01' then 1 else 0 end jan_retention
from
(
select user_id
,account_id
,min(date) as first_date
, max(date) as last_date
from sf_events
group by user_id
, account_id
) as table1
) as table2
group by account_id