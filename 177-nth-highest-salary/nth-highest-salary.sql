CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET  N=N-1;
  RETURN (
      select salary from Employee
      group by salary
      order by salary desc
      LIMIT 1 OFFSET N
  );
END