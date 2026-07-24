package JavaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BasicPrgm {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 101,-1);

        //1.        Program to print even numbers from the list
        List<Integer> evenList = list.stream()
                .filter(e -> e % 2 == 0)
                .toList();
        System.out.println("Problem 1:  " + evenList);

        //2.        Program to print odd numbers from the list
        List<Integer> oddList = list.stream()
                .filter(e -> e % 2 != 0)
                .toList();
        System.out.println("Problem 2:  " + oddList);

        //3.        Map Integer to Squares
        List<Double> squaresList = list.stream()
                                    .map(e -> Math.pow(e, 2))
                                    .toList();
        System.out.println("Problem 3:  " + squaresList);

        //4.	    Map strings to uppercase
        List<String> name = List.of("vinayak", "Nimbaragi");
        List<String> upperCaseName = name.stream()
                                        .map(String::toUpperCase)
                                        .toList();
        System.out.println("Problem 4:  " + upperCaseName);

        //5.	    Map strings to lower
        List<String> lowerCaseName = name.stream()
                                    .map(String::toLowerCase)
                                    .toList();
        System.out.println("Problem 5:  " + lowerCaseName);

        //6.        Find sum of all numbers using reduce
        int sum = list.stream().reduce(0, Integer::sum);
        // sum=list.stream().reduce((a,b)->a+b).get();
        System.out.println("Problem 6:  " + sum);

        //7.        Find product of all numbers using reduce
        int product = list.stream()
                .reduce(1,(a, b) -> a * b);
        System.out.println("Problem 7:  " + product);

        //8.        Find maximum number using streams
        int max = list.stream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Problem 8:  " + max);

        //9.       Find minimum number using streams
        int min = list.stream().reduce(1,Integer::min);
        System.out.println("Problem 9:  " + min);

        //10.      Sort numbers in ascending order
        List<Integer> ascendingOrder = list.stream().sorted().toList();
        System.out.println("Problem 10:  " + ascendingOrder);

        //11.      Sort numbers in descending order
        List<Integer> descendingOrder = list.stream().sorted(Comparator.reverseOrder()).toList();
        //descendingOrder =list.stream().sorted((a,b)->b-a).toList();
        System.out.println("Problem 11:  " + descendingOrder);

        //12.	Find the first element using findFirst()
        int firstElement = list.stream().findFirst().orElseThrow();
        System.out.println("Problem 12:  " + firstElement);

        //13.	Find any element using findAny()
        int findAny = list.stream().findAny().get();
        System.out.println("Problem 13:  " + findAny);

        //14.	Count total elements in a list()
        long count = list.size();
        System.out.println("Problem 14:  " + count);

        //15.	Remove duplicates using distinct
        List<Integer> distinct = list.stream().distinct().toList();
        System.out.println("Problem 15:  " + distinct);

        //16.	Check if any number is greater than 100
        boolean greaterThan = list.stream().anyMatch(e -> e > 100);
        System.out.println("Problem 16:  " + greaterThan);

        //17.	Check if all numbers are positive
        boolean AllArePositive=list.stream().allMatch(e->e>=0);
        System.out.println("Problem 17:  "+AllArePositive);

        //18.	Check if none of the numbers are negative
        boolean noneOfTheNumbersAreNegative=list.stream().noneMatch(e->e<0);
        System.out.println("Problem 18:  "+noneOfTheNumbersAreNegative);

        //19.	Skip the first 3 elements
        List<Integer> skipElement=list.stream().skip(3).toList();
        System.out.println("Problem 19:  "+skipElement);


        //20.	Limit the stream to first 5 elements
        List<Integer> limitElement=list.stream().limit(5).toList();
        System.out.println("Problem 20:  "+limitElement);


        // 21.	Find the second highest number
        int secondHighest=list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println("Problem 21:  "+secondHighest);


        //22.	Find the second lowest number
        int secoudLowest=list.stream()
                        .sorted()
                        .skip(1)
                        .findFirst()
                        .orElseThrow();
        System.out.println("Problem 22:  "+secoudLowest);


        //23.	Join a list of strings with comma
        String n= String.join(",", name);
        System.out.println("Problem 23:  "+n);


        //24.	Find the average of numbers
        double avg=list.stream()
                .mapToInt(Integer::intValue).
                average()
                .orElse(0);
        System.out.println("Problem 24:  "+avg);


        //25.	Convert list of strings to list of their lengths
        List<Integer>lengthName=name.stream()
                .map(String::length)
                .toList();
        System.out.println("Problem 25:  "+lengthName);


        //26.	Find the longest string using Comparator
        String longName=name.stream()
                .max(Comparator.comparing(String::length))
                .orElseThrow();
        System.out.println("Problem 26:  "+longName);


        //27.	Find the shortest string using Comparator
        String shortName=name.stream()
                .min(Comparator.comparing(String::length))
                .orElseThrow();
        System.out.println("Problem 27:  "+shortName);


        //28.	Sort strings by length in reverse order
        List<String> sortedByLengthDesc = name.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
        System.out.println("Problem 28:  "+sortedByLengthDesc);


        //29.	Find the sum of squares of numbers
        int sumSquare=list.stream()
                    .map(e->e*e)
                    .reduce(0,Integer::sum);
//        int sumSquare=list.stream()
//                .map(e->e*e)
//                .reduce(Integer::sum)
//                .orElseThrow();
        System.out.println("Problem 29:  "+sumSquare);


        //30.	Multiply only even numbers
        int multiEven=list.stream()
                .filter(e->e%2==0)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Problem 30:  "+multiEven);
    }
}
