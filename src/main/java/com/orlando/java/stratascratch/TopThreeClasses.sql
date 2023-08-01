WITH cte AS
  (SELECT product_class,
          RANK() OVER (
                       ORDER BY COUNT(*) DESC) rnk
   FROM online_orders s
   JOIN online_products p ON s.product_id = p.product_id
   GROUP BY 1)
SELECT product_class
FROM cte
WHERE rnk <= 3;