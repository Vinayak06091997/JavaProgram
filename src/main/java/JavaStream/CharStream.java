package JavaStream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharStream {

    public static void main(String[] args)
    {
        String name="vinayak";
        String sentence = "java streams are very powerful and streams are fun";
        String s1 = "listen";
        String s2 = "silent";

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

        //11.  Count how many digits are in a string.
//        int countDigit= Math.toIntExact(name.chars()
//                .mapToObj(c -> (char) c)
//                .filter(c -> "0123456789".indexOf(c) != -1)
//                .count());

        //or
        int countDigit= Math.toIntExact(name.chars().filter(Character::isDigit).count());

        System.out.println("Problem:-11    " + countDigit);



        //12.  Count how many letters are in a string.
        int countletters= Math.toIntExact(name.chars()
                .filter(Character::isAlphabetic)
                .count());

        System.out.println("Problem:-12    " + countletters);

        //13.  Count how many spaces are in a string.
        int countSpaces= Math.toIntExact(name.chars()
                        .filter(Character::isSpaceChar)
                        .count());
        System.out.println("Problem:-13    " + countSpaces);


        //14.  Find the longest word in a sentence (single string).
        String longest =
                Arrays.stream(sentence.split("\\s+"))
                        .max(Comparator.comparingInt(String::length))
                        .orElse("");
        System.out.println("Problem:-14    " + longest);

        //15.  Find the shortest word in a sentence (single string).
        String shortest =
                Arrays.stream(sentence.split("\\s+"))
                        .min(Comparator.comparingInt(String::length))
                        .orElse("");

        System.out.println("Problem:-15    " + shortest);


        //16.  Count the frequency of each word in a sentence.
        Map<String, Long> wordFreq =
                Arrays.stream(sentence.split("\\s+"))
                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println("Problem:-16    " + wordFreq);

        //17.  Find the most frequent word in a sentence.
        String mostFrequent =
                Arrays.stream(sentence.split("\\s+"))
                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse("");
        System.out.println("Problem:-17    " + mostFrequent);

        //18.  Find the least frequent word in a sentence.
        String leastFrequent =
                Arrays.stream(sentence.split("\\s+"))
                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .min(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse("");
        System.out.println("Problem:-18    " + leastFrequent);

        //19.  Find the top 3 most frequent words in a sentence.
        List<String> top3 =
                Arrays.stream(sentence.split("\\s+"))
                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .limit(3)
                        .map(Map.Entry::getKey)
                        .toList();
        System.out.println("Problem:-19    " + top3);

        //20.   Check if two strings are anagrams using streams.
        String sorted1 =
                s1.chars()
                        .sorted()
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining());

        String sorted2 =
                s2.chars()
                        .sorted()
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining());

        boolean isAnagram = sorted1.equals(sorted2);
        System.out.println("Problem:-20    " + isAnagram);

    }
}
