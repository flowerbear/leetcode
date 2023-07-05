merge-overlapping-events-in-the-same-hall

Table: HallEvents

+-------------+------+
| Column Name | Type |
+-------------+------+
| hall_id     | int  |
| start_day   | date |
| end_day     | date |
+-------------+------+
There is no primary key in this table. It may contain duplicates.
Each row of this table indicates the start day and end day of an event and the hall in which the event is held.


Write an SQL query to merge all the overlapping events that are held in the same hall. Two events overlap if they have at least one day in common.

Return the result table in any order.

The query result format is in the following example.



Example 1:

Input:
HallEvents table:
+---------+------------+------------+
| hall_id | start_day  | end_day    |
+---------+------------+------------+
| 1       | 2023-01-13 | 2023-01-14 |
| 1       | 2023-01-14 | 2023-01-17 |
| 1       | 2023-01-18 | 2023-01-25 |
| 2       | 2022-12-09 | 2022-12-23 |
| 2       | 2022-12-13 | 2022-12-17 |
| 3       | 2022-12-01 | 2023-01-30 |
+---------+------------+------------+
Output:
+---------+------------+------------+
| hall_id | start_day  | end_day    |
+---------+------------+------------+
| 1       | 2023-01-13 | 2023-01-17 |
| 1       | 2023-01-18 | 2023-01-25 |
| 2       | 2022-12-09 | 2022-12-23 |
| 3       | 2022-12-01 | 2023-01-30 |
+---------+------------+------------+
Explanation: There are three halls.
Hall 1:
- The two events ["2023-01-13", "2023-01-14"] and ["2023-01-14", "2023-01-17"] overlap. We merge them in one event ["2023-01-13", "2023-01-17"].
- The event ["2023-01-18", "2023-01-25"] does not overlap with any other event, so we leave it as it is.
Hall 2:
- The two events ["2022-12-09", "2022-12-23"] and ["2022-12-13", "2022-12-17"] overlap. We merge them in one event ["2022-12-09", "2022-12-23"].
Hall 3:
- The hall has only one event, so we return it. Note that we only consider the events of each hall separately.

with recursive rn_cte as (
	select *,
    ROW_NUMBER() over (ORDER BY hall_id, start_day) as row_num
    from (select DISTINCT * from test.HallEvents) h
),
merge_cte_recursive as (
	select
      hall_id,
      start_day,
      end_day,
      row_num
	from rn_cte r
    where r.row_num = 1
    union
    select
      r.hall_id,
      case when r.hall_id = m.hall_id and r.start_day <= m.end_day
      then m.start_day else r.start_day end as start_day,
      case when r.hall_id = m.hall_id and r.end_day <= m.end_day
      then m.end_day else r.end_day end as end_day,
      r.row_num
	from rn_cte r
    join merge_cte_recursive m on r.row_num = m.row_num + 1
    where r.row_num <= (select max(row_num) from rn_cte)
)
select
hall_id,
start_day,
max(end_day) as end_day
from merge_cte_recursive
group by hall_id, start_day;

WITH event_cte AS (
  SELECT IFNULL(start_day > MAX(end_day) OVER w, 1) AS is_new_event_start,
         hall_id,
         start_day,
         end_day
  FROM HallEvents
  WINDOW w AS (PARTITION BY hall_id
               ORDER BY start_day ASC, end_day ASC
               ROWS BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING)
),
event_id_cte AS (
  SELECT SUM(is_new_event_start) OVER w AS event_id,
         hall_id,
         start_day,
         end_day
  FROM event_cte
  WINDOW w AS (PARTITION BY hall_id
               ORDER BY start_day ASC, end_day ASC)
)
SELECT hall_id,
       MIN(start_day) AS start_day,
       MAX(end_day) AS end_day
FROM event_id_cte
GROUP BY hall_id, event_id
ORDER BY NULL;

SELECT hall_id,
       MIN(start_day) AS start_day,
       MAX(end_day) AS end_day
FROM (
    SELECT *,
           SUM(range_start) OVER (PARTITION BY hall_id ORDER BY start_day) AS range_grp
    FROM (
        SELECT *,
               CASE WHEN start_day <= LAG(max_end_day_so_far) OVER (PARTITION BY hall_id ORDER BY start_day) THEN 0
                    ELSE 1 END AS range_start
        FROM (
            SELECT hall_id,
                   start_day,
                   end_day,
                   MAX(end_day) OVER (PARTITION BY hall_id ORDER BY start_day) AS max_end_day_so_far
            FROM HallEvents
        ) t
    ) t1
) t2
GROUP BY hall_id, range_grp;