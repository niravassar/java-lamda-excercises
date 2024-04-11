package hacker.rank;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class HackerRank {
    public static void main(String[] args) {
        Predicate<Integer> evenCheck = i -> i % 2 == 0;
        Predicate<Integer> isPrime = i -> isPrime(i);
        Predicate<String> isPalindrome = s -> s.contentEquals(new StringBuffer(s).reverse());
    }

    public static boolean isPrime(int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }
}
