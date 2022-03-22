select a.id
from weather a, weather b
where TO_DAYS(a.recordDate)-TO_DAYS(b.recordDate)=1 and a.temperature > b.temperature