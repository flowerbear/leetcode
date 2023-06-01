The Numbers table keeps the value of number and its frequency.

+----------+-------------+
|  Number  |  Frequency  |
+----------+-------------|
|  0       |  7          |
|  1       |  1          |
|  2       |  3          |
|  3       |  1          |
+----------+-------------+
In this table, the numbers are 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3, so the median is (0 + 0) / 2 = 0.

+--------+
| median |
+--------|
| 0.0000 |
+--------+
Write a query to find the median of all numbers and name the result as median.

select avg(Number) as median from (
    select n1.Number from Numbers n1 join Numbers n2 on n1.Number >= n2.Number
        group by n1.Number
        having
        sum(n2.Frequency) >= (select sum(Frequency) from Numbers) / 2
        and
        sum(n2.Frequency) - avg(n1.Frequency) <= (select sum(Frequency) from Numbers) / 2
) med;
