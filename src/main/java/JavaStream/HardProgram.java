package JavaStream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HardProgram {
    static class Transaction {
        String user;
        double amount;

        Transaction(String user, double amount) {
            this.user = user;
            this.amount = amount;
        }

        public String getUser() {
            return user;
        }

        public double getAmount() {
            return amount;
        }
    }

    static class Item {
        String name;

        Item(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Item)) return false;
            Item item = (Item) o;
            return Objects.equals(name, item.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class Order {
        List<Item> items;

        Order(List<Item> items) {
            this.items = items;
        }

        public List<Item> getItems() {
            return items;
        }
    }

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
        String sentence="Hello Hi Vinayak";

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

        String str1 = "listen";
        String str2 = "silent";

        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);
        List<Integer> list3 = List.of(5, 6, 7, 8, 9);

        List<String> names = Arrays.asList("Amit", "Rahul", null, "Sneha", "Ankit", null, "Zara");

        List<Long> bigList = Arrays.asList(
                1_000_000_000L,
                2_000_000_000L,
                3_000_000_000L,
                4_000_000_000L
        );

        List<Transaction> transactions = List.of(
                new Transaction("Rahul", 100.0),
                new Transaction("Rahul", 200.0),
                new Transaction("Sneha", 150.0),
                new Transaction("Amit", 300.0),
                new Transaction("Sneha", 50.0)
        );

        List<Order> orders = List.of(
                new Order(List.of(new Item("Pen"), new Item("Book"))),
                new Order(List.of(new Item("Pencil"), new Item("Book"))),
                new Order(List.of(new Item("Pen"), new Item("Notebook")))
        );

        //71. Second-highest salary employee
            Employee secondHighest = employees.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                    .skip(1)
                    .findFirst()
                    .orElseThrow();

            System.out.println("71: " + secondHighest);


        //72. N-th the highest salary employee
            int n = 3;
            Employee nthHighest = employees.stream()
                    .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                    .skip(n - 1)
                    .findFirst()
                    .orElseThrow();

            System.out.println("72: " + nthHighest);


        //73. Group by dept and sort each group by salary desc
            Map<String, List<Employee>> groupedSorted = employees.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDept,
                            Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    employees1->employees1.stream()
                                            .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                                            .toList()
                            )
                    ));

            System.out.println("73: " + groupedSorted);


        //74. Partition active/inactive and count
            Map<Boolean, Long> countByStatus = employees.stream()
                    .collect(Collectors.partitioningBy(Employee::isActive, Collectors.counting()));

            System.out.println("74: " + countByStatus);

        //75. Dept-wise highest paid employee
            Map<String, Optional<Employee>> highestByDept = employees.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDept,
                            Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
                    ));

            System.out.println("75: " + highestByDept);


        //76. Dept-wise avg salary, sort depts desc
            Map<String, Double> avgSalarySorted = employees.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDept,
                            Collectors.averagingInt(Employee::getSalary)))
                    .entrySet().stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> a,
                            LinkedHashMap::new
                    ));

            System.out.println("76: " + avgSalarySorted);


        //77. From string, chars with count > 1
            List<Character> dupChars = sentence.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("77: " + dupChars);

        //78. From string, all unique chars
            List<Character> unique = sentence.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("78: " + unique);



        //79. Longest word in a sentence
            String longest = Arrays.stream(sentence.split("\\s+"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println("79: " + longest);



        //80. Shortest word in a sentence
            String shortest = Arrays.stream(sentence.split("\\s+"))
                .min(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("80: " + shortest);


        //81. Word frequency from a sentence
            Map<String, Long> freq = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("81: " + freq);



        //82. Sort words by frequency desc
            Map<String, Long> sortedFreq = freq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b)->a, LinkedHashMap::new));
        System.out.println("82: " + sortedFreq);


        //83. Top 3 most frequent words
            List<String> top3 = freq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("83: " + top3);


        //84. Total amount spent per user (Transaction: user, amount)
            Map<String, Double> totalByUser = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getUser, Collectors.summingDouble(Transaction::getAmount)));
        System.out.println("84: " + totalByUser);


        //85. User with max total amount
            String topUser = totalByUser.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
        System.out.println("85: " + topUser);


        //86. From orders, flatten all items & distinct
            List<Item> items = orders.stream()
                .flatMap(o -> o.getItems().stream())
                .distinct()
                .toList();
        System.out.println("86: " + items);


        //87. Find consecutive duplicates
            List<Integer> consecutive = IntStream.range(1, list.size())
                .filter(i -> list.get(i).equals(list.get(i-1)))
                .mapToObj(list::get)
                .toList();
        System.out.println("87: " + consecutive);


        //88. Check anagrams
            boolean isAnagram = Arrays.equals(  str1.chars().sorted().toArray(),
                                                str2.chars().sorted().toArray()
                                             );
        System.out.println("88: " + isAnagram);



        //   89. Group numbers by ranges (0–10, 11–20, …)
            Map<Integer, List<Integer>> byRange = list.stream()
                .collect(Collectors.groupingBy(n1 -> (n1 / 10) * 10));
        System.out.println("89: " + byRange);


        // 90. Map<Dept, Map<Gender, List<Employee>>>
            Map<String, Map<String, List<Employee>>> map1 =
                employees.stream().collect(Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.groupingBy(Employee::getDept)
                ));
        System.out.println("90: " + map1);


        // 91. Custom collector to join with "|"
            Collector<String, StringBuilder, String> pipeJoiner =
                    Collector.of(StringBuilder::new,
                            (sb, s) -> { if (sb.length()>0) sb.append("|"); sb.append(s); },
                            StringBuilder::append,
                            StringBuilder::toString);
        System.out.println("91: " + pipeJoiner);


        // 92. Find missing numbers in range
            List<Integer> missing = IntStream.rangeClosed(1, 100)
                .filter(i -> !list.contains(i))
                .boxed()
                .toList();
        System.out.println("92: " + missing);


        // 93. Intersection of three lists
            List<Integer> inter = list1.stream()
                .filter(list2::contains)
                .filter(list3::contains)
                .distinct()
                .toList();
        System.out.println("93: " + inter);



        // 94. Union of three lists
            List<Integer> union = Stream.of(list1, list2, list3)
                .flatMap(List::stream)
                .distinct()
                .toList();
        System.out.println("94: " + union);


        //95. Difference between two lists
            List<Integer> diff = list1.stream()
                .filter(e -> !list2.contains(e))
                .toList();
        System.out.println("95: " + diff);



        //96. Sort but keep nulls at end
            List<String> sorted = names.stream()
                .sorted(Comparator.nullsLast(String::compareTo))
                .toList();
        System.out.println("96: " + sorted);


        //97. Top 3 salaries using reduce
            List<Integer> top3Salaries = employees.stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println("97: " + top3Salaries);



        //98. Sum large numbers safely using parallelStream
        long sum = bigList.parallelStream()
                .mapToLong(Long::longValue)
                .sum();
        System.out.println("98: " + sum);


        //99. Compare stream vs parallelStream correctness
        long s1 = list.stream()
                .mapToLong(Integer::longValue)
                .sum();
        long s2 = list.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        System.out.println(s1 == s2);


        //100. Full pipeline: filter → map → group → sort → collect
            Map<String, Long> result = employees.stream()
                .filter(Employee::isActive)
                .map(Employee::getDept)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b)->a, LinkedHashMap::new));

        System.out.println("100: " + result);


    }
}
