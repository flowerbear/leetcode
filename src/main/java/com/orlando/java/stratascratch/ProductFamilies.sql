SELECT product_family,
       COALESCE(SUM(units_sold), 0) as units_sold,
       COALESCE(COALESCE(SUM(CASE
                                   WHEN pr.promotion_id IS NOT NULL THEN units_sold
                                   ELSE 0 END), 0) / SUM(units_sold) * 100, 0) as perc_with_valid_promotion
FROM facebook_products p
LEFT JOIN facebook_sales s ON s.product_id = p.product_id
LEFT JOIN facebook_sales_promotions pr ON pr.promotion_id = s.promotion_id
GROUP BY product_family