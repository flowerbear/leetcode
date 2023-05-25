First and Last Call On the Same Day

Table: Calls

+--------------+----------+
| Column Name  | Type     |
+--------------+----------+
| caller_id    | int      |
| recipient_id | int      |
| call_time    | datetime |
+--------------+----------+
(caller_id, recipient_id, call_time) is the primary key for this table.
Each row contains information about a call the time of a call between caller_id and recipient_id.
Write an SQL query to report the IDs of the user who had the first and the last call with the same person on any day.

Return the result table in any order.

The query result format is in the following example:

Calls table:
+-----------+--------------+---------------------+
| caller_id | recipient_id | call_time           |
+-----------+--------------+---------------------+
| 8         | 4            | 2021-08-24 17:46:07 |
| 4         | 8            | 2021-08-24 19:57:13 |
| 5         | 1            | 2021-08-11 05:28:44 |
| 8         | 3            | 2021-08-17 04:04:15 |
| 11        | 3            | 2021-08-17 13:07:00 |
| 8         | 11           | 2021-08-17 22:22:22 |
+-----------+--------------+---------------------+

Result table:
+---------+
| user_id |
+---------+
| 1       |
| 4       |
| 5       |
| 8       |
+---------+

On 2021-08-24, the first and last call of this day for user 8 was with user 4. User 8 should be included in the answer.
Similary, User 4 had the first and last call on 2021-08-24 with user 8. User 4 should be included in the answer.
On 2021-08-11, user 1 and 5 had a call. The call was the only call for both of them on this day. Since this call is the first and last call of the day for both of them, they both should be included in the answr.

WITH call_cte AS
(
    SELECT caller_id AS user_id, call_time, recipient_id
    FROM Calls
    UNION
    SELECT recipient_id AS user_id, call_time, caller_id AS recipient_id
    FROM Calls
),
call_ordering_cte AS
(
    SELECT  user_id, recipient_id, DATE(call_time) AS day,
    RANK() OVER(PARTITION BY user_id, DATE(call_time) ORDER BY call_time ASC) AS first,
    RANK() OVER(PARTITION BY user_id, DATE(call_time) ORDER BY call_time DESC) AS last
    FROM call_cte
)
SELECT DISTINCT user_id
FROM call_ordering_cte
WHERE first = 1 OR last = 1
GROUP BY user_id, day
HAVING COUNT(DISTINCT recipient_id) = 1
ORDER BY NULL;