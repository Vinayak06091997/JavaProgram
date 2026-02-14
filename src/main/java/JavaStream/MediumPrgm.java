package JavaStream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MediumPrgm {
    static class Employee {
        String name;
        String dept;
        int salary;

        Employee() {
            name = "vinayak";
            dept = "ISE";
            salary=70000;
        }

        Employee(String name, String dept,int salary) {
            this.name = name;
            this.dept = dept;
            this.salary=salary;
        }
        String getDept()
        {
            return dept;
        }
        String getName()
        {
            return name;
        }
        int getSalary()
        {
            return salary;
        }
        @Override
        public String toString() {
            return "Employee{name='" + name + "', dept='" + dept + "', salary='" + salary+"'}";
        }
    }

    public static void main(String[] args)
    {
        List<Integer> list=List.of(1,2,3,4,5,6,7,8,9,0,10,1,2);
        List<String>  name=List.of("Vinayak","Nimbaragi","Benaluru","Vinayak");
        List<Employee> employees = List.of(
                new Employee("Rahul", "IT",20000),
                new Employee("Sneha", "HR",20000),
                new Employee("Amit", "Finance",20000),
                new Employee("Neha", "IT",20000),
                new Employee("Vinayak", "ISE",20000)
        );


        //31.	Count frequency of each number in a list
        Map<Integer,Long> countFrequency=list.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Problem 31: " + countFrequency);

        //32.	Count frequency of each word in a list
        Map<String,Long> countFrequencyWord=name.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Problem 32: " + countFrequencyWord);

        //33.	Find duplicate numbers in a list
        List<Integer> duplicateNumber=list.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Problem 33: " + duplicateNumber);

//        countFrequencyWordSet<Integer> seen = new HashSet<>();
//
//        List<Integer> duplicateNumber = list.stream()
//                .filter(e -> !seen.add(e))  // add() returns false if already present
//                .distinct()
//                .toList();
//
//        System.out.println("Problem 33: " + duplicateNumber);


        //34.	Find unique numbers in a list
        List<Integer> uniqueNumber=list.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("Problem 34: " + uniqueNumber);


        //35.	Partition numbers into even and odd using partitioningBy
        Map<Boolean,List<Integer>> partitioningBy=list.stream()
                .collect(Collectors.partitioningBy(e-> e % 2 ==0));
        System.out.println("Evens: " + partitioningBy.get(true));
        System.out.println("Odds: " + partitioningBy.get(false));
        System.out.println("Problem 35: " + partitioningBy);

        //36.	Group strings by their length
        Map<Integer, List<String>> groupStringLength=name.stream()
                .collect((Collectors.groupingBy(String::length)));
        System.out.println("Problem 36: " + groupStringLength);

        //37.	Group employees by department
        Map<String, List<Employee>> employeesByDept = employees.stream().
                  collect(Collectors.groupingBy(e->e.dept));
                  //  collect(Collectors.groupingBy(Employee::getDept));
        System.out.println("Problem 37: " + employeesByDept);

        //If you want only names per department
        Map<String, List<String>> getEmployeesNameByDept = employees.stream().
                collect(Collectors.groupingBy(
                        e->e.dept,
                        Collectors.mapping(e->e.name,Collectors.toList())
                ));
        System.out.println("Problem 37: " + getEmployeesNameByDept);

        //38.	Count employees in each department
        Map<String,Long> countEmployee=employees.stream()
                .collect((Collectors.groupingBy(
                        e->e.dept,
                        Collectors.counting()
                )));
        System.out.println("Problem 38: " + countEmployee);

        //39.	Find average salary per department using averagingDouble
        Map<Object, Double> averageSalary=employees.stream()
                .collect((Collectors.groupingBy(
                                e->e.dept,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                ));
        System.out.println("Problem 39: " + averageSalary);

        //40.	Find maximum salary per department
       Map<String, Optional<Employee>> maxSalaryPerDept=employees.stream()
                .collect(Collectors.groupingBy(
                        e->e.dept,
                        Collectors.maxBy(Comparator.comparingDouble( Employee::getSalary))));
        System.out.println("Problem 40: " + maxSalaryPerDept);

        //41.	Find minimum salary per department
        Map<String, Optional<Employee>> miniSalaryPerDept=employees.stream()
                .collect(Collectors.groupingBy(
                        e->e.dept,
                        Collectors.minBy(Comparator.comparingDouble( Employee::getSalary))));
        System.out.println("Problem 41: " + miniSalaryPerDept);

        //42.	Find the highest paid employee overall

    }
}
