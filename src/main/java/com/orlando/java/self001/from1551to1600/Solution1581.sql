select customer_id, count(1) as count_no_trans
from (
select customer_id
from visits v left outer join transactions t on v.visit_id = t.visit_id
where t.transaction_id is null) a
group by customer_id;