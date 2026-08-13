SELECT 
    ROUND(COUNT( CASE WHEN a.event_date=DATE_ADD(f.FIRST, INTERVAL 1 DAY) THEN 1 END)
    /COUNT(DISTINCT f.player_id) ,2)AS fraction
FROM Activity a
join(
    select player_id,MIN(event_date) as FIRST
    from Activity
    GROUP BY player_id
) as f
on a.player_id=f.player_id;