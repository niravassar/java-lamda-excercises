package excercises;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SumCalculator sumCalculator = (a, b) -> a+b;
        System.out.println("Sum Lamba: " + sumCalculator.sum(5, 7));

        StringEmpty stringEmpty = s -> s.isEmpty();
        System.out.println("String empty: " + stringEmpty.isEmpty(""));

        System.out.println("to Upper and lower case:");
        List<String> stringList = Arrays.asList("Red", "Green", "Blue", "PINK");
        stringList.stream().map(String::toUpperCase).forEach(System.out::println);
        List<String> lowerCase = stringList.stream().map(String::toLowerCase).toList();
        lowerCase.forEach(System.out::println);

        List<Integer> integers = Arrays.asList(1, 3, 4, 2, 8, 7, 10);
        List<Integer> even = integers.stream().filter(s  -> s % 2 == 0).toList();
        System.out.println("Even list: " + even);

        List<Integer> odd = integers.stream().filter(s  -> s % 2 != 0).toList();
        System.out.println("Even odd: " + odd);
    }
}