#This is so far the hardest "Hard" questions for MySQL in Stratascratch in my opinion#
with recursive
cte1 as (   #Table cte1 to remove "[" and "]" character and count max words in each row
    select
        *,
        replace(replace(post_keywords, "[", ""), "]", "") as keywords,
        length(post_keywords) - length(replace(post_keywords, ",", "")) + 1 as max_word_count
    from facebook_posts ),
cte2 as (   #Recursive table cte2 to sieve out columns with multiple words into multiple rows with single word each
    select  #Anchor member
        poster,
        keywords,
        substring_index(substring_index(keywords, ",", max_word_count), ",", -1) as split_word,
        max_word_count
    from cte1
    union all
    select  #Recursive member
        poster,
        keywords,
        substring_index(substring_index(keywords, ",", max_word_count - 1), ",", -1) as split_word,
        max_word_count - 1
    from cte2
    where max_word_count > 1    )   #Terminating member
select #Final view to calculate words that are overlapping between two different posters
    table1.poster as p1,
    table2.poster as p2,
    #table1.split_word as p1_word,
    #table2.split_word as p2_word,
    count(table2.split_word) / count(table1.split_word) as overlap
from cte2 as table1
left join cte2 as table2
on table1.poster <> table2.poster and table1.split_word = table2.split_word
group by p1
having count(table2.split_word) / count(table1.split_word) > 0
order by p1 asc, p2 asc;