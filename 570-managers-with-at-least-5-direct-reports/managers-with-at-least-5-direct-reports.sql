select name from Employee as e
where id in(
    select managerId from Employee
    group by managerId
    having count(*)>=5
);
