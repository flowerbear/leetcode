WITH grouped AS (
    SELECT
        DATE_ADD(date_visited, INTERVAL -ROW_NUMBER()
            OVER (PARTITION BY user_id ORDER BY date_visited) DAY) AS grp,
        user_id,
        date_visited
    FROM (
        SELECT *
        FROM user_streaks
        GROUP BY date_visited, user_id) dates
)
SELECT
    user_id, streak_length
FROM (
    SELECT user_id, COUNT(*) - 1 as streak_length
    FROM grouped
    GROUP BY user_id, grp
    ORDER BY COUNT(*) desc) c
GROUP BY user_id
LIMIT 3;