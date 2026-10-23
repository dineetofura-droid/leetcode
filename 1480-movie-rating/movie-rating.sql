(
    SELECT u.name AS results
    FROM MovieRating m
    JOIN Users u ON m.user_id = u.user_id
    GROUP BY u.user_id, u.name
    ORDER BY COUNT(*) DESC, u.name
    LIMIT 1
)
UNION ALL
(
    SELECT m2.title
    FROM MovieRating r
    JOIN Movies m2 ON r.movie_id = m2.movie_id
    WHERE r.created_at >= '2020-02-01'
      AND r.created_at < '2020-03-01'
    GROUP BY m2.movie_id, m2.title
    ORDER BY AVG(r.rating) DESC, m2.title
    LIMIT 1
);