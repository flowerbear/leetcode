select search_id,
       MAX(CASE WHEN clicked = 0 THEN 1
            WHEN clicked = 1 AND search_results_position > 3 THEN 2
            WHEN clicked = 1 AND search_results_position <= 3 THEN 3
            END) AS rating
FROM fb_search_events
GROUP BY 1