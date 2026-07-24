

1) To find the second highest salary from a table named "Employee" with a column "Salary",
    select Max(Salary)
    from Employee
    where salary<
          (select Max(Salary) from Employee);

    or
    select Salary
    from Employee
    order by Salary desc
    Limit 1 offset 1;

2) To find the highest salary each department from a table named "Employee" with columns "Salary" and "Department",
    select Department, Max(Salary) as HighestSalary
    from Employee
    group by Department;

3) Employee Having salary greater than averge
    select *
    from Employee
    where Salary > (select Avg(Salary) from Employee);

4) duplicate records
    select Salary, count(*)
    from Employee
    group by Salary
    having count(*) > 1;

5) DELETE duplicate records
    delete e1
    from Employee e1
    inner join Employee e2
    on e1.Salary = e2.Salary
    where e1.id > e2.id;

6) To find the third highest salary from Employee,

    select Salary
    from Employee
    order by Salary desc
        limit 1 offset 2;

    or

    select Salary
    from
        (
            select Salary,
                   Dense_Rank() over(order by Salary desc) as rnk
            from Employee
        ) e
    where rnk = 3;


7) To find the Nth highest salary,

    select Salary
    from
        (
            select Salary,
                   Dense_Rank() over(order by Salary desc) as rnk
            from Employee
        ) e
    where rnk = N;


8) To find the employee(s) having maximum salary,

    select *
    from Employee
    where Salary =
          (
              select Max(Salary)
              from Employee
          );


9) To find the employee(s) having minimum salary,

    select *
    from Employee
    where Salary =
          (
              select Min(Salary)
              from Employee
          );


10) To find department-wise employee count,

    select Department,
           Count(*) as EmployeeCount
    from Employee
    group by Department;


11) To find department-wise average salary,

    select Department,
           Avg(Salary) as AverageSalary
    from Employee
    group by Department;


12) To find departments having more than 5 employees,

    select Department,
           Count(*) as EmployeeCount
    from Employee
    group by Department
    having Count(*) > 5;


13) To find top 3 highest salaries,

    select distinct Salary
    from Employee
    order by Salary desc
        limit 3;


14) To find employees whose salary is between 50000 and 100000,

    select *
    from Employee
    where Salary between 50000 and 100000;


15) To find employees whose name starts with 'A',

    select *
    from Employee
    where Name like 'A%';


16) To find employees whose name ends with 'K',

    select *
    from Employee
    where Name like '%K';


17) To find employees whose name contains 'AN',

    select *
    from Employee
    where Name like '%AN%';


18) To find employees whose department is NULL,

    select *
    from Employee
    where Department is null;


19) To find employees who are not assigned to any department,

    select *
    from Employee
    where Department is null;


20) To find total salary of all employees,

select Sum(Salary) as TotalSalary
from Employee;


21) To find average salary of all employees,

    select Avg(Salary) as AverageSalary
    from Employee;


22) To find maximum salary,

select Max(Salary)
from Employee;


23) To find minimum salary,

select Min(Salary)
from Employee;


24) To count total number of employees,

select Count(*)
from Employee;


25) To find employees whose salary is greater than department average,

select *
from Employee e
where Salary >
      (
          select Avg(Salary)
          from Employee
          where Department = e.Department
      );