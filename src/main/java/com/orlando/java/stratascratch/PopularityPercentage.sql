SELECT user1, COUNT(*) / (SELECT COUNT(DISTINCT user1) FROM (SELECT user1 FROM facebook_friends UNION SELECT user2 FROM facebook_friends) AS users_union) * 100 AS popularity_percent
FROM (SELECT user1, user2 FROM facebook_friends UNION SELECT user2 AS user1, user1 AS user2 FROM facebook_friends) AS users_union
GROUP BY 1
ORDER BY 1