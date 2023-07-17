select score, my_rank as 'rank'
from (
select score, DENSE_RANK() over (order by score DESC) my_rank
from scores) a
order by my_rank;

SELECT s.score, COUNT(1) AS 'rank'
FROM Scores s,
     (SELECT DISTINCT score AS score FROM Scores) r
WHERE s.score <= r.score
GROUP BY s.id
ORDER BY s.score DESC;