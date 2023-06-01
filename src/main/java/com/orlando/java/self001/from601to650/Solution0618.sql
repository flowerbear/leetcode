A U.S graduate school has students from Asia, Europe and America. The students’ location information are stored in table student as below.

| name   | continent |
|--------|-----------|
| Jack   | America   |
| Pascal | Europe    |
| Xi     | Asia      |
| Jane   | America   |
Pivot the continent column in this table so that each name is sorted alphabetically and displayed underneath its corresponding continent. The output headers should be America, Asia and Europe respectively. It is guaranteed that the student number from America is no less than either Asia or Europe.

For the sample input, the output is:

| America | Asia | Europe |
|---------|------|--------|
| Jack    | Xi   | Pascal |
| Jane    |      |        |
Follow-up: If it is unknown which continent has the most students, can you write a query to generate the student report?

SELECT am.name as America, asia.name as Asia eu.name as Europe
FROM
(SELECT row_number() over (order by name) rn, name
FROM student
WHERE continent = 'America') AS am
left join
(SELECT row_number() over (order by name) rn, name
FROM student
WHERE continent = 'Europe') AS eu
on am.rn = eu.rn
left join
(SELECT row_number() over (order by name) rn, name
FROM student
WHERE continent = 'Asia') As asia
on am.rm = asia.rn;