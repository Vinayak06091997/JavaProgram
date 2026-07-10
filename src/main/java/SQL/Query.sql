

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