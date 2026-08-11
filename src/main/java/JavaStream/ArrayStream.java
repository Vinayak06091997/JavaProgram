package JavaStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayStream {

    public static void main(String[] args){
        int[] a= {1,2,3,4,5,1};
        int[] b= {6,7,8,9,0};

        //1. From an int[], filter all even numbers.
        int[] evenNumber=Arrays.stream(a)
                                .filter(e->e%2==0)
                                .toArray();
        System.out.println("Problem:-1      "+Arrays.toString(evenNumber));

        //2. From an int[], filter all odd numbers.
        int[] oddNumber=Arrays.stream(a)
                                .filter(e->e%2!=0)
                                .toArray();
        System.out.println("Problem:-2     "+Arrays.toString(oddNumber));

        //3. Find the sum of all elements in an int[].
        int sum=Arrays.stream(a).reduce(Integer::sum).orElseThrow();
        System.out.println("Problem:-3     "+sum);

        //4. Find the product of all elements in an int[] using reduce.
        int productElement=Arrays.stream(a).reduce((a1,b1)->a1*b1).orElseThrow();
        System.out.println("Problem:-4     "+productElement);

        //5. Find the maximum element in an int[].
        int maxNumber=Arrays.stream(a).max().orElseThrow();
        System.out.println("Problem:-5     "+maxNumber);

        //6. Find the minimum element in an int[].
        int miniNumber=Arrays.stream(a).min().orElseThrow();
        System.out.println("Problem:-6     "+miniNumber);

        //7. Sort an int[] in ascending order using streams.
        int[] sortAscending=Arrays.stream(a).sorted().toArray();
        System.out.println("Problem:-7     "+ Arrays.toString(sortAscending));

        //8. Sort an int[] in descending order using streams.
        int [] sortDescending=Arrays.stream(a)
                            .boxed()// convert int to object
                            .sorted(Comparator.reverseOrder())
                            .mapToInt(Integer::intValue)  // Object to int
                            .toArray();
        System.out.println("Problem:-8     "+ Arrays.toString(sortDescending));

        //9 Remove duplicate elements from an int[].
        int[] duplicateElement=Arrays.stream(a)
                                .distinct()
                                .toArray();
        System.out.println("Problem:-9     "+ Arrays.toString(duplicateElement));

        //10 Count how many elements are greater than 50.
        int count=((int) Arrays.stream(a).filter(e -> e > 50).count());
        System.out.println("Problem:-10     "+ count);

        //11. Find the second highest number in an int[].
        int secondHighest=Arrays.stream(a)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println("Problem:-11     "+ secondHighest);

        //12 Find the second lowest number in an int[].
        int secondLowest=Arrays.stream(a)
                .sorted()
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println("Problem:-12     "+ secondLowest);

        //13. Find the top 3 highest numbers in an int[].
        int[] threeHighestNumbers= Arrays.stream(a)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println("Problem:-13     "+ Arrays.toString(threeHighestNumbers));


        //14. Find the bottom 3 smallest numbers in an int[].
        int[] threeLowestNumbers= Arrays.stream(a)
                .sorted()
                .limit(3)
                .toArray();
        System.out.println("Problem:-14     "+ Arrays.toString(threeLowestNumbers));


        //15. Check if any number is greater than 100.
        boolean anyNumberIsGreaterThan100=Arrays.stream(a)
                                        .anyMatch(e->e>100);

        System.out.println("Problem:-15     "+ anyNumberIsGreaterThan100);


        //16 Check if all numbers are positive.
        boolean  allNumbersArePositive=Arrays.stream(a)
                                            .allMatch(e->e>0);

        System.out.println("Problem:-16     "+ allNumbersArePositive);

        //17. Check if none of the numbers are negative.
        boolean  noneOfTheNumbersAreNegative=Arrays.stream(a)
                                            .noneMatch(e->e<0);
        System.out.println("Problem:-17     "+ noneOfTheNumbersAreNegative);

        //18. Skip the first 3 elements and collect the rest into an array.
        int[] skipFirst3Elements=Arrays.stream(a)
                                            .skip(3).toArray();
        System.out.println("Problem:-18     "+ Arrays.toString(skipFirst3Elements));

        //19. Limit the stream to the first 5 elements and collect into an array.
        int[] limitFirst3Elements=Arrays.stream(a)
                                            .limit(3).toArray();
        System.out.println("Problem:-19     "+ Arrays.toString(limitFirst3Elements));

        //20. Find the average of numbers in an int[]
        int averageNumber= (int) Arrays.stream(a)
                                    .average()
                                    .orElseThrow();
        System.out.println("Problem:-20     "+ averageNumber);

        //21 sum of 2 array to 3rd array

        int [] c=IntStream.range(0, a.length)
                            .map(i->a[i]+b[i])
                            .toArray();
        System.out.println("Problem:-21     "+ Arrays.toString(c));


        //22 sum of all elements of both arrays into one number
        int sumAllElement=IntStream.concat(Arrays.stream(a),Arrays.stream(b))
                            .sum();
        System.out.println("Problem:-22     "+ sumAllElement);

        //23 Merge two sorted arrays
        int[] mergedArray=IntStream.concat(Arrays.stream(a),Arrays.stream(b))
                            .sorted()
                            .toArray();
        System.out.println("Problem:-23     "+ Arrays.toString(mergedArray));

        //24. Count duplicate elements
        long duplicateCount=Arrays.stream(a)
                            .filter(x->Arrays.stream(b).anyMatch(y->y==x))
                            .count();
        System.out.println("Problem:-24     "+ duplicateCount);

        //25. Find the intersection of two arrays
        int[] intersection=Arrays.stream(a)
                            .filter(x->Arrays.stream(b).anyMatch(y->y==x))
                            .toArray();
        System.out.println("Problem:-25     "+ Arrays.toString(intersection));

        //26.First duplicate element
        Set<Integer> set = new HashSet<>();
        int firstDuplicate = Arrays.stream(a)
                .filter(x -> !set.add(x))
                .findFirst()
                .orElse(-1);

        System.out.println("Problem:-26     " + firstDuplicate);

        //27. Reverse an array
        int[] reverse = IntStream.range(0, a.length)
                .map(i -> a[a.length - 1 - i])
                .toArray();

        System.out.println("Problem:-28     " + Arrays.toString(reverse));

        //29. Convert int[] to List<Integer>
        List<Integer> list = Arrays.stream(a)
                .boxed()
                .toList();
        System.out.println("Problem:-29     " + list);

        //30. prime Number using stream
        int[] primeNumber=
                IntStream.range(0,100)
                        .filter(e-> IntStream.range(2,e)
                                .noneMatch(x->e%x==0)).toArray();
        System.out.println("Prime Numbers are: ");
        for (int j : primeNumber) {
            System.out.print(j + " ");
        }

        //31. fibonacci series using stream
        final int[] a1 = {1};
        final int[] b1 = {2};
        IntStream.range(1,10).map(e->{
                    int c1= a1[0] + b1[0];
                    a1[0] = b1[0];
                    b1[0] =c1;
                    return c1;})
                .forEach(System.out::println);
    }
}
