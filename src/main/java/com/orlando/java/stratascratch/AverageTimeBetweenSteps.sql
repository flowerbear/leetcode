WITH lag_cte AS
  (SELECT feature_id,
          user_id,
          TIMESTAMP AS TIMESTAMP,
          LAG(TIMESTAMP, 1) OVER (PARTITION BY feature_id,
                                               user_id
                                  ORDER BY step_reached ASC) AS prev_timestamp
   FROM facebook_product_features_realizations),
     time_difference AS
  (SELECT feature_id,
          user_id,
          TIMESTAMPDIFF(SECOND, prev_timestamp, TIMESTAMP) AS elapsed_time
   FROM lag_cte
   WHERE prev_timestamp IS NOT NULL) ,
     avg_time_per_user AS
  (SELECT feature_id,
          user_id,
          AVG(elapsed_time) AS avg_elapsed_time
   FROM time_difference
   GROUP BY feature_id,
            user_id)
SELECT feature_id,
       AVG(avg_elapsed_time)
FROM avg_time_per_user
GROUP BY feature_id