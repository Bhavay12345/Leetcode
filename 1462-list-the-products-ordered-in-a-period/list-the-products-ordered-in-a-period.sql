select 
    p.product_name,
    SUM(o.unit) as unit
from Products as p
left join Orders as o
on p.product_id=o.product_id
where o.order_date>='2020-02-01' AND o.order_date<'2020-03-01'
group by p.product_name
having SUM(o.unit)>=100;