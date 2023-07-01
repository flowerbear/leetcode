Leetcodify Friends Recommendations

Table: Listens

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| user_id     | int     |
| song_id     | int     |
| day         | date    |
+-------------+---------+
There is no primary key for this table. It may contain duplicates.
Each row of this table indicates that the user user_id listened to the song song_id on the day day.
Table: Friendship

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| user1_id      | int     |
| user2_id      | int     |
+---------------+---------+
(user1_id, user2_id) is the primary key for this table.
Each row of this table indicates that the users user1_id and user2_id are friends.
Note that user1_id < user2_id.
Write an SQL query to recommend friends to Leetcodify users. We recommend user x to user y if:

Users x and y are not friends, and
Users x and y listened to the same three or more different songs on the same day.
Note that friend recommendations are unidirectional, meaning if user x and user y should be recommended to each other, the result table should have both user x recommended to user y and user y recommended to user x. Also, note that the result table should not contain duplicates (i.e., user y should not be recommended to user x multiple times.).

Return the result table in any order.

The query result format is in the following example:

Listens table:
+---------+---------+------------+
| user_id | song_id | day        |
+---------+---------+------------+
| 1       | 10      | 2021-03-15 |
| 1       | 11      | 2021-03-15 |
| 1       | 12      | 2021-03-15 |
| 2       | 10      | 2021-03-15 |
| 2       | 11      | 2021-03-15 |
| 2       | 12      | 2021-03-15 |
| 3       | 10      | 2021-03-15 |
| 3       | 11      | 2021-03-15 |
| 3       | 12      | 2021-03-15 |
| 4       | 10      | 2021-03-15 |
| 4       | 11      | 2021-03-15 |
| 4       | 13      | 2021-03-15 |
| 5       | 10      | 2021-03-16 |
| 5       | 11      | 2021-03-16 |
| 5       | 12      | 2021-03-16 |
+---------+---------+------------+

Friendship table:
+----------+----------+
| user1_id | user2_id |
+----------+----------+
| 1        | 2        |
+----------+----------+

Result table:
+---------+----------------+
| user_id | recommended_id |
+---------+----------------+
| 1       | 3              |
| 2       | 3              |
| 3       | 1              |
| 3       | 2              |
+---------+----------------+
Users 1 and 2 listened to songs 10, 11, and 12 on the same day, but they are already friends.
Users 1 and 3 listened to songs 10, 11, and 12 on the same day. Since they are not friends, we recommend them to each other.
Users 1 and 4 did not listen to the same three songs.
Users 1 and 5 listened to songs 10, 11, and 12, but on different days.

Similarly, we can see that users 2 and 3 listened to songs 10, 11, and 12 on the same day and are not friends, so we recommend them to each other.

WITH recommend_cte
     AS (SELECT DISTINCT a.user_id user_id,
                         b.user_id recommended_id
         FROM   listens a
                INNER JOIN listens b ON a.user_id != b.user_id AND a.day = b.day AND a.song_id = b.song_id
         GROUP  BY a.user_id,
                   b.user_id,
                   a.day
         HAVING Count(DISTINCT a.song_id) >= 3
         ORDER  BY NULL)

SELECT user_id,
       recommended_id
FROM   recommend_cte a
WHERE  NOT EXISTS
     (SELECT 1
      FROM   friendship b
      WHERE  (a.user_id = b.user1_id AND a.recommended_id = b.user2_id)
             OR
             (a.user_id = b.user2_id AND a.recommended_id = b.user1_id));

SELECT DISTINCT l.user_id,
       l.recommended_id
FROM (
    SELECT l1.user_id AS user_id,
           l2.user_id AS recommended_id
    FROM Listens l1 INNER JOIN Listens l2 ON (l1.user_id != l2.user_id
                                              AND l1.song_id = l2.song_id
                                              AND l1.day = l2.day)
    GROUP BY l1.user_id, l2.user_id, l1.day
    HAVING COUNT(DISTINCT l1.song_id) >= 3
) l
LEFT JOIN (
    SELECT user1_id,
           user2_id
    FROM Friendship
    UNION
    SELECT user2_id,
           user1_id
    FROM Friendship
) f
ON (l.user_id = f.user1_id AND l.recommended_id = f.user2_id)
WHERE f.user1_id IS NULL AND f.user2_id IS NULL
ORDER BY l.user_id, l.recommended_id;