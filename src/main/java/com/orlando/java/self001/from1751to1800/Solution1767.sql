Find the Subtasks That Did Not Execute

Table: Tasks

+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| task_id        | int     |
| subtasks_count | int     |
+----------------+---------+
task_id is the primary key for this table.
Each row in this table indicates that task_id was divided into subtasks_count subtasks labelled from 1 to subtasks_count.
It is guaranteed that 2 <= subtasks_count <= 20.
Table: Executed

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| task_id       | int     |
| subtask_id    | int     |
+---------------+---------+
(task_id, subtask_id) is the primary key for this table.
Each row in this table indicates that for the task task_id, the subtask with ID subtask_id was executed successfully.
It is guaranteed that subtask_id <= subtasks_count for each task_id.
Write an SQL query to report the IDs of the missing subtasks for each task_id.

Return the result table in any order.

The query result format is in the following example:

Tasks table:
+---------+----------------+
| task_id | subtasks_count |
+---------+----------------+
| 1       | 3              |
| 2       | 2              |
| 3       | 4              |
+---------+----------------+

Executed table:
+---------+------------+
| task_id | subtask_id |
+---------+------------+
| 1       | 2          |
| 3       | 1          |
| 3       | 2          |
| 3       | 3          |
| 3       | 4          |
+---------+------------+

Result table:
+---------+------------+
| task_id | subtask_id |
+---------+------------+
| 1       | 1          |
| 1       | 3          |
| 2       | 1          |
| 2       | 2          |
+---------+------------+
Task 1 was divided into 3 subtasks (1, 2, 3). Only subtask 2 was executed successfully, so we include (1, 1) and (1, 3) in the answer.
Task 2 was divided into 2 subtasks (1, 2). No subtask was executed successfully, so we include (2, 1) and (2, 2) in the answer.
Task 3 was divided into 4 subtasks (1, 2, 3, 4). All of the subtasks were executed successfully.

WITH RECURSIVE CTE AS
  (SELECT 1 AS subtask_id
   UNION ALL SELECT subtask_id + 1
   FROM CTE
   WHERE subtask_id <
       (SELECT MAX(subtasks_count)
        FROM Tasks) )
SELECT Tasks.task_id,
       CTE.subtask_id
FROM CTE
INNER JOIN Tasks ON CTE.subtask_id <= Tasks.subtasks_count
LEFT JOIN Executed ON Tasks.task_id = Executed.task_id
                      AND CTE.subtask_id = Executed.subtask_id
WHERE Executed.subtask_id IS NULL
ORDER BY NULL;


WITH Recursive all_tasks AS (
    SELECT task_id,
           1 AS subtask_id
    FROM Tasks
    UNION
    SELECT a.task_id,
           subtask_id + 1
    FROM all_tasks a INNER JOIN Tasks t ON (a.task_id = t.task_id)
    WHERE a.subtask_id < t.subtasks_count
)
SELECT task_id,
       subtask_id
FROM all_tasks LEFT JOIN Executed e USING (task_id, subtask_id)
WHERE e.task_id IS NULL;