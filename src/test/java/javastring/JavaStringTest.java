package javastring;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class JavaStringTest {

    @Test
    void fizzBuzz() {
        // print Fizz for multiples of 5, mulitples of 7 print Buzz -- print 1 to 100. if both mult of 5 and 7, print FizzBuzz
        IntStream.range(1, 101).mapToObj(i -> {
            String result = "";
            if (i % 5 == 0) {
                result += "Fizz";
                if (i % 7 == 0) {
                    result += "Buzz";
                }
            } else if (i % 7 == 0) {
                result += "Buzz";
            } else {
                result += String.valueOf(i);
            }
            return result;
        }).forEach(System.out::println);
    }

    @Test
    void reverseString() {
        String anyString = "Nirav";
        char[] charArray = anyString.toCharArray();
        char[] charArray2 = new char[charArray.length];
        int start = 0;
        int end = charArray.length - 1;
        int index = 0;
        while (end >= start) {
            System.out.println(charArray[end]);
            charArray2[index] = charArray[end];
            end--;
            index++;
        }
        System.out.println(new String(charArray2));
    }

    @Test
    void palindrome() {
        List<String> palindromes = List.of("bahab", "maham", "nope");
        palindromes.stream().map(string -> new StringBuilder(string).reverse().toString().equals(string)).forEach(System.out::println);
    }

    @Test
    void anagram() {
        // the two words have all the same letter
        String one = "bragxfrr";
        String two = "grabxfrr";

        if (one.length() == two.length()) {
            int length = one.length();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < length; i++) {
                set.add(one.charAt(i));
                set.add(two.charAt(i));
            }
            if (set.size() == one.length()) {
                System.out.println("chars are same");
            } else {
                System.out.println("chars are not same");
            }
        } /// this messes up for length when they have 3 r's

        if (one.length() == two.length()) {
            char[] array1 = one.toCharArray();
            char[] array2 = two.toCharArray();
            Arrays.sort(array1);
            Arrays.sort(array2);
            if (Arrays.equals(array1, array2)) {
                System.out.println("chars are same");
            }
        }
    }
}
