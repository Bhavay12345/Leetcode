select c.name AS customers from Customers as c
left join Orders as o
on c.id=o.customerId
where o.id is null;
