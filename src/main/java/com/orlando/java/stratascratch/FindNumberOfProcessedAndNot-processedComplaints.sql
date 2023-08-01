WITH BASE AS (
select
    type,
    CASE
        WHEN processed = 1 THEN 1
    END as pr,
    CASE
        WHEN processed = 0 OR processed IS NULL THEN 1
    END as np
from facebook_complaints
)
SELECT type, SUM(pr) , SUM(np)
FROM BASE
group by 1