package JavaStream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MediumProgram {
    static class Employee {
        int id;
        String name;
        String dept;
        int salary;
        boolean active;

        Employee(int id,String name, String dept, int salary, boolean active) {
            this.id=id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
            this.active = active;
        }
        String getName()
        {
            return name;
        }

        String getDept()
        {
            return dept;
        }
        int getSalary()
        {
            return salary;
        }
        int getId()
        {
            return id;
        }

        public boolean isActive() {
            return active;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', dept='" + dept + "', salary=" + salary + ", active=" + active + "}";
        }

    }

    public static void main(String[] args)
    {
        List<Integer> list=List.of(1,2,3,4,5,6,7,8,9,0,10,1,2);
        List<String>  name=List.of("Vinayak","Nimbaragi","Benaluru","Vinayak");
        List<String> listWithNulls = Arrays.asList("A", null, "B", null, "C", "D", null);

        Map<String ,Integer> map=new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        List<List<Integer>> listOfList=Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(1,2,3),
                Arrays.asList(1,2,3)
                );
        List<Employee> employees = List.of(
                new Employee(1,"Rahul", "IT", 60000, true),
                new Employee(2,"Neha", "IT", 70000, false),
                new Employee(3,"Sneha", "HR", 50000, true),
                new Employee(4,"Amit", "Finance", 80000, false),
                new Employee(5,"Vinayak", "ISE", 55000, true)
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
        Employee highestPaidEmployee=employees.stream()
                .max(Comparator.comparing(e->e.salary)).orElseThrow();
        System.out.println("Problem 42: " + highestPaidEmployee);

        //43.	Find the lowest paid employee overall
        Employee lowestPaidEmployee=employees.stream()
                .min(Comparator.comparing(e->e.salary)).orElseThrow();
        System.out.println("Problem 43: " + lowestPaidEmployee);

        //44.	Sort employees by salary
        List<Employee> sortEmployee=employees.stream()
                .sorted(Comparator.comparingDouble(e->e.salary)).toList();
        System.out.println("Problem 44: " + sortEmployee);

        //45.	Sort employees by salary descending, then by name ascending
        List<Employee> sortEmployeeDescending=employees.stream()
                .sorted(
                        Comparator.comparingDouble(
                                        (Employee e)->e.salary)
                            .reversed()
                            .thenComparing(e->e.name)
                    )
                    .toList();
        System.out.println("Problem 45: " + sortEmployeeDescending);

        //46.	Find top 3 highest numbers
        List<Employee> top3Employee=employees.stream()
                                    .sorted(Comparator.comparingDouble((Employee::getSalary)).reversed())
                                    .limit(3)
                                    .toList();
        System.out.println("Problem 46: " + top3Employee);

        //47.	47.	Find bottom 3 numbers
        List<Employee> bottom3Employee=employees.stream()
                .sorted(Comparator.comparingDouble((Employee::getSalary)))
                .limit(3)
                .toList();
        System.out.println("Problem 47: " + bottom3Employee);

        //48.	Remove null values from a list
        List<String> notNullList=listWithNulls.stream()
                .filter(Objects::nonNull)
                .toList();
        System.out.println("Problem 48: " + notNullList);

        //49.	Flatten a list of lists into a single list using flatMap
        List<Integer> listMap=listOfList.stream().
                flatMap(Collection::stream)
                .toList();
        System.out.println("Problem 49: " + listMap);

        //50.	Convert a list of strings into a list of characters
        List<Character> listOfString=name.stream().
                            flatMap(s->s.chars()
                            .mapToObj(c->(char)c))
                            .toList();
        System.out.println("Problem 50: " + listOfString);


        //51.	Find the first non-repeated character in a string
        String nameMine="vinayakv";
        char nonRepeating=nameMine.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,        // 👈 preserves order
                        Collectors.counting()
                        ))
                .entrySet()
                .stream()
                .filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();

        System.out.println("Problem 51: " + nonRepeating);

        //52.	Find the first repeated character in a string
        char firstRepeating=nameMine.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,        // 👈 preserves order
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();

        System.out.println("Problem 52: " + firstRepeating);

        //53.	Reverse a string using streams

        System.out.println("String: "+
                nameMine.chars()
                        .mapToObj(c -> String.valueOf((char) c))
                        .sorted().collect(Collectors.joining()));

        String reverseString=nameMine.chars()
                            .mapToObj(c->(char)c)
                            .collect(StringBuilder::new,
                                    StringBuilder::append,
                                    StringBuilder::append)
                .reverse()
                .toString();
        System.out.println("Problem 53: " + reverseString);

        //withOut Stream
        reverseString=new StringBuilder(nameMine)
                            .reverse()
                            .toString();
        System.out.println("Problem 53-1: " + reverseString);

        //54.	Check if a string is palindrome using streams
        boolean isPalindrome= IntStream.range(0,nameMine.length()/2)
                .allMatch(i->nameMine.charAt(i)==nameMine.charAt(nameMine.length()-i-1));
        System.out.println("Problem 54: " + isPalindrome);


        //55.	Find the sum of only even numbers

        int sumEvenNumber=list.stream()
                .filter(e->e%2==0)
                .reduce(Integer::sum).orElseThrow();
        System.out.println("Problem 55: " + sumEvenNumber);

//        int sumEvenNumber = list.stream()
//                .filter(e -> e % 2 == 0)
//                .mapToInt(Integer::intValue)
//                .sum();
//
//        System.out.println("Problem 55: " + sumEvenNumber);

        //56.	Find the product of only odd numbers

        int productOddNumber=list.stream()
                .filter(e->e%2!=0)
                .reduce((a,b)->a*b)
                .orElseThrow();
        System.out.println("Problem 56: " + productOddNumber);


        //57.	Partition employees into active and inactive
        Map<Boolean,List<Employee>> partitionEmployee=employees.stream()
                .collect(Collectors.partitioningBy(Employee::isActive));

        System.out.println("Problem 57: " + partitionEmployee);
        System.out.println("Problem 57:-True: " + partitionEmployee.get(true));
        System.out.println("Problem 57:-False: " + partitionEmployee.get(false));

        //58.	Convert a list to Map<id, object>

        Map<Integer, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,   // key = id
                        e -> e             // value = employee object
                ));

        System.out.println("Problem 58: " + employeeMap);

        //59. Handle duplicate keys while collecting into a map
        Map<Integer, Employee> map1 = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        e -> e,
                        (e1, e2) -> e1   // keep first (or e2 to keep second)
                ));
        System.out.println("Problem 59: " + map1);

        //60. Sort a map by values
        Map<String, Integer> sortedByValue = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        System.out.println("Problem 60: " + sortedByValue);


        //61. Sort a map by keys
        Map<String, Integer> sortedByKey = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        System.out.println("Problem 61: " + sortedByKey);


       // 62. Find the longest string in a list
        String longest = name.stream()
                .max(Comparator.comparingInt(String::length))
                .orElseThrow();

        System.out.println("Problem 62: " + longest);

        //63. Find the shortest string in a list
        String shortest = name.stream()
                .min(Comparator.comparingInt(String::length))
                .orElseThrow();
        System.out.println("Problem 63: " + shortest);



        //64. Count total characters in a list of strings
        int totalChars = name.stream()
                .mapToInt(String::length)
                .sum();

        System.out.println("Problem 64: " + totalChars);

       // 65. Find strings starting with letter 'A'
        List<String> startWithA = name.stream()
                .filter(s -> s.startsWith("A"))
                .toList();
        System.out.println("Problem 65: " + startWithA);



        //66. Find strings ending with letter 's'
        List<String> endWithS = name.stream()
                .filter(s -> s.endsWith("s"))
                .toList();
        System.out.println("Problem 66: " + endWithS);


        //67. Find common elements between two lists
        List<Integer> common = list.stream()
                .filter(list::contains)
                .distinct()
                .toList();
        System.out.println("Problem 67: " + common);



        //68. Find elements present in list1 but not in list2
        List<Integer> onlyInList1 = list.stream()
                .filter(e -> !list.contains(e))
                .toList();

        System.out.println("Problem 68: " + onlyInList1);


        //69. Merge two lists and remove duplicates
        List<Integer> mergedDistinct = Stream.concat(list.stream(), list.stream())
                .distinct()
                .toList();
        System.out.println("Problem 69: " + mergedDistinct);


        //70. Find the k-th highest number
        int k = 3; // for example, 3rd highest

        int kthHighest = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(k - 1)
                .findFirst()
                .orElseThrow();
        System.out.println("Problem 70: " + kthHighest);


    }
}
