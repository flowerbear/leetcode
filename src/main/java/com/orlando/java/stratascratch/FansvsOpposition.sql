SELECT fans.employee_fan_id,
       opposition.employee_opposition_id
FROM
  (SELECT employee_id AS employee_fan_id,
          ROW_NUMBER() OVER (
                             ORDER BY popularity DESC, employee_id asc) AS position
  FROM  facebook_hack_survey) fans
INNER JOIN
  (SELECT employee_id AS employee_opposition_id,
          ROW_NUMBER() OVER (
                             ORDER BY popularity ASC, employee_id asc) AS position
  FROM  facebook_hack_survey) opposition
  ON fans.position = opposition.position