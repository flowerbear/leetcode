Longest Winning Streak

Table: Matches

+-------------+------+
| Column Name | Type |
+-------------+------+
| player_id   | int  |
| match_day   | date |
| result      | enum |
+-------------+------+
(player_id, match_day) is the primary key for this table.
Each row of this table contains the ID of a player, the day of the match they played, and the result of that match.
The result column is an ENUM type of ('Win', 'Draw', 'Lose').


The winning streak of a player is the number of consecutive wins uninterrupted by draws or losses.

Write an SQL query to count the longest winning streak for each player.

Return the result table in any order.

The query result format is in the following example.



Example 1:

Input:
Matches table:
+-----------+------------+--------+
| player_id | match_day  | result |
+-----------+------------+--------+
| 1         | 2022-01-17 | Win    |
| 1         | 2022-01-18 | Win    |
| 1         | 2022-01-25 | Win    |
| 1         | 2022-01-31 | Draw   |
| 1         | 2022-02-08 | Win    |
| 2         | 2022-02-06 | Lose   |
| 2         | 2022-02-08 | Lose   |
| 3         | 2022-03-30 | Win    |
+-----------+------------+--------+
Output:
+-----------+----------------+
| player_id | longest_streak |
+-----------+----------------+
| 1         | 3              |
| 2         | 0              |
| 3         | 1              |
+-----------+----------------+
Explanation:
Player 1:
From 2022-01-17 to 2022-01-25, player 1 won 3 consecutive matches.
On 2022-01-31, player 1 had a draw.
On 2022-02-08, player 1 won a match.
The longest winning streak was 3 matches.

Player 2:
From 2022-02-06 to 2022-02-08, player 2 lost 2 consecutive matches.
The longest winning streak was 0 matches.

Player 3:
On 2022-03-30, player 3 won a match.
The longest winning streak was 1 match.

with cte as (
select player_id, match_day, result, row_number() over(partition by player_id order by match_day) as seq
from Matches
),
cte_group_of_win as (
select player_id, seq - row_number() over (partition by player_id order by match_day) as group_id
from cte
where result = 'Win'
),
cte_win_cnt as (
select player_id, group_id, count(*) as cnt
from cte_group_of_win
group by 1, 2
)
select player_id, ifnull(max(cnt), 0) as longest_streak
from (select distinct player_id from Matches) a left join cte_win_cnt b on a.player_id = b.player_id
group by 1;


SELECT player_id,
       MAX(winning_streak) AS longest_streak
FROM (
    SELECT *,
           SUM(IF(result = 'Win', 1, 0)) AS winning_streak
    FROM (
        SELECT *,
               SUM(IF(result = 'Win', 0, 1)) OVER (PARTITION BY player_id ORDER BY match_day) AS grp
        FROM Matches
    ) t
    GROUP BY player_id, grp
) t1
GROUP BY player_id;

SELECT player_id,
       MAX(winning_streak) AS longest_streak
FROM (
    SELECT player_id,
           SUM(result = 'Win') AS winning_streak
    FROM (
        SELECT *,
               ROW_NUMBER() OVER (PARTITION BY player_id ORDER BY match_day) AS rk1,
               ROW_NUMBER() OVER (PARTITION BY player_id, result ORDER BY match_day) AS rk2
        FROM Matches
    ) t
    GROUP BY player_id, rk1-rk2
) t1
GROUP BY player_id;