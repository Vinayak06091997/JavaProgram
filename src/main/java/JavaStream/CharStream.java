package JavaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharStream {

    public static void main(String[] args)
    {
        String name="vinayak";


        //1.Count the frequency of each character in a string.
        Map<Character,Long> frequency=name.chars()
                                        .mapToObj(c->(char)c)
                                        .collect(Collectors.groupingBy(
                                                                Function.identity(),
                                                                Collectors.counting()
                                        ));
        System.out.println("Problem:-1     "+ frequency);

        //2. Find the first non-repeated character in a string.
        char nonRepeatedCharacter=name.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,     //insertion order
                        Collectors.counting()
                ))
                .entrySet()
                .stream().filter(e->e.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
        System.out.println("Problem:-2     "+ nonRepeatedCharacter);

        //3. Find the first repeated character in a string.
        char repeatedCharacter=name.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,     //insertion order
                        Collectors.counting()
                ))
                .entrySet()
                .stream().filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
        System.out.println("Problem:-3     "+ repeatedCharacter);

        //4.    Reverse a string using streams.
        String reverseName=name.chars()
                                    .mapToObj(c->String.valueOf((char)c))
                                   .reduce("",(a,b)-> (b+a));
        System.out.println("Problem:-3     "+ reverseName);


        //5. Check if a string is a palindrome using streams.
        boolean isPalindrome= IntStream.range(0,name.length()/2)
                                .allMatch(i->name.charAt(i)==name.charAt(name.length()-i-1));
        System.out.println("Problem:-5     " + isPalindrome);


        //6. Count the number of vowels in a string.
        int countVowels= Math.toIntExact(name.chars()
                                    .mapToObj(c -> (char) c)
                                    .filter(e -> "aeiouAEIOU".indexOf(e) != -1).count());
        System.out.println("Problem:-6     " + countVowels);


        //7. Remove duplicate characters from a string.
        String removeDuplicate=name.chars()
                                .mapToObj(c->String.valueOf((char)c))
                                .distinct()
                                .collect(Collectors.joining());
        System.out.println("Problem:-7     " + removeDuplicate);

        //8. Sort the characters of a string alphabetically.
        String charSort=name.chars()
                        .mapToObj(c->String.valueOf((char)c))
                                .sorted()
                                .collect(Collectors.joining());
        System.out.println("Problem:-8     " + charSort);


        //9. Find the maximum (highest ASCII) character in a string.
        char maxChar=name.chars()
                .mapToObj(c->(char)c)
                .max(Comparator.naturalOrder())
                .orElseThrow();
        System.out.println("Problem:-9     " + maxChar);

        //10. Find the minimum (lowest ASCII) character in a string.
        char miniChar=name.chars()
                .mapToObj(c->(char)c)
                .min(Comparator.naturalOrder())
                .orElseThrow();
        System.out.println("Problem:-10    " + miniChar);

    }
}
