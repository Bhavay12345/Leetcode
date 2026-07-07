select class from Courses
group by class
having COUNT(*)>4;
