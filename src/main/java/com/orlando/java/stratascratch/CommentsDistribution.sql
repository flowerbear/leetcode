SELECT comment_cnt,
       count(t.id) AS user_cnt
FROM
  (SELECT a.id,
          count(*) AS comment_cnt
   FROM fb_users a
   INNER JOIN fb_comments b ON a.id=b.user_id
   WHERE b.created_at BETWEEN '2020-01-01' AND '2020-01-31'
     AND a.joined_at BETWEEN '2018-01-01' AND '2020-12-31'
     AND datediff(b.created_at, a.joined_at) >= 0
   GROUP BY a.id) t
GROUP BY comment_cnt
ORDER BY comment_cnt ASC