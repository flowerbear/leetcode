WITH RECURSIVE MergeSortCTE AS (
  SELECT
    ROW_NUMBER() OVER (ORDER BY value) AS id,
    value
  FROM unsorted_numbers
),
RecursiveCTE AS (
  SELECT
    id,
    value
  FROM MergeSortCTE
  WHERE id = 1

  UNION ALL

  SELECT
    M.id,
    M.value
  FROM MergeSortCTE M
  JOIN RecursiveCTE R ON R.id + 1 = M.id
),
MergeCTE AS (
  SELECT
    R1.value AS value1,
    R2.value AS value2
  FROM RecursiveCTE R1
  JOIN RecursiveCTE R2 ON R1.id + 1 = R2.id
),
MergedCTE AS (
  SELECT
    value1,
    value2 AS value
  FROM MergeCTE

  UNION ALL

  SELECT
    value2,
    value1 AS value
  FROM MergeCTE
),
FinalCTE AS (
  SELECT
    value
  FROM MergedCTE
)
SELECT
  value
FROM FinalCTE
ORDER BY value;