with page_loads as
    (select user_id, timestamp
    from facebook_web_log
    where action = 'page_load'),
scroll_downs as
    (select user_id, timestamp
    from facebook_web_log
    where action = 'scroll_down'),
user_time_diff as
    (select a.user_id, a.timestamp as page_load_time, b.timestamp as scroll_down_time,
    timestampdiff(second, a.timestamp, b.timestamp) as time_diff
    from page_loads a
    left join scroll_downs b
    on a.user_id = b.user_id
    and a.timestamp <= b.timestamp)

select user_id, page_load_time, scroll_down_time, time_format(time_diff, '%H:%i:%s') as time_diff
from user_time_diff
where time_diff = (select min(time_diff) from user_time_diff)