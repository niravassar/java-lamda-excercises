package play;

import org.apache.commons.lang3.ArrayUtils;
import org.assertj.core.internal.Arrays;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class NiravPlayTest {

    @Test
    void leetCode1637WidestVeriticalArea() {
        //1637. Widest Vertical Area Between Two Points Containing No Points
        //https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/description/
        //int[][] sample = { {8,7},{9,9},{7,4},{9,7} };
        //System.out.println(maxWidthOfVerticalArea(sample));
        int[][] sample2 = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};
        System.out.println(maxWidthOfVerticalArea(sample2));
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        List<Integer> integers = new ArrayList<>();
        int length = points.length;
        for (int i = 0; i < length; i++) {
            integers.add(points[i][0]);
        }
        Collections.sort(integers);
        List<Integer> result = new ArrayList<>();

        int greatestValue = 0;
        for (int i = 0; i < length; i++) {
            int x = integers.get(i);
            int area = 0;
            if (i < length - 1) {
                area = Math.abs(x - integers.get(i+1));
            }
            if (area > greatestValue) {
                greatestValue = area;
            }
            result.add(greatestValue);
        }
        return Collections.max(result);
    }

    @Test
    void hiredSample1() {
        assertThat(solution1(new long[] {9L, 10L, 15})).isEqualTo(15);
        assertThat(solution1(new long[] {})).isEqualTo(0);
        assertThat(solution2(new long[] {9L, 10L, 15})).isEqualTo(15);
        assertThat(solution2(new long[] {})).isEqualTo(0);
    }

    private long solution1(long[] numbers) {
        Long[] longObjects = ArrayUtils.toObject(numbers);
        List<Long> myList = new ArrayList<>(List.of(longObjects));
        return myList.stream().max(Long::compareTo).orElse(0L);
    }

    private long solution2(long[] numbers) {
        long greatest = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > greatest) {
                greatest = numbers[i];
            }
        }
        return greatest;
    }

    @Test
    void leftOrRight() {
        System.out.println(leftOrRight(new long[] {3L, 6L, 2,9,-1,10}));
        System.out.println(leftOrRight(new long[] {3L, 6L, 2,9,-1,99}));
        System.out.println(leftOrRight(new long[] {3L, 6L, 2,9,-1,13}));
        System.out.println(leftOrRight(new long[] {}));
        System.out.println(leftOrRight(new long[] {1, 4, 100, 5}));
        System.out.println(leftOrRight(new long[] {1, 10, 5, 1, 0, 6}));
    }

    private String leftOrRight(long[] arr) {
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        boolean leftSide = true; // true is left, false is right
        for (int i = 0; i < arr.length; i++) {
            long value = arr[i];
            if (value != -1 && i != 0) {
                if (leftSide) {
                    left.add(value);
                } else {
                    right.add(value);
                }
                leftSide = !leftSide;
            }
        }
        long leftTotal = left.stream().mapToLong(i->i).sum();
        long rightTotal = right.stream().mapToLong(i->i).sum();


        if (leftTotal > rightTotal) {
            return "Left";
        } else if (leftTotal < rightTotal) {
            return "Right";
        } else {
            return "None";
        }
    }

    @Test
    void countWaysStairs() {
        System.out.println(countWays(3));
        System.out.println(countWays(4));
        System.out.println(countWays(5));
    }

    public int countWays(int n)
    {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2] + res[i - 3];

        return res[n];
    }

    @Test
    void brackets() {
        System.out.println(brackets("><<><"));
    }

    private String brackets(String angles){
        char [] chars = angles.toCharArray();
        int greaterThanCount=0;
        int lessThanCount=0;
        for (int i=0; i < chars.length; i++) {
            if (chars[i] == '>') {
                greaterThanCount++;
            } else {
                lessThanCount++;
            }
        }
        System.out.println("the string: " + angles);
        System.out.println("greater than >: " + greaterThanCount);
        System.out.println("less than <: " + lessThanCount);

        String prepend = "";
        for (int i=0; i < greaterThanCount; i++) {
            prepend+= "<";
        }

        String postpend = "";
        for (int i=0; i < lessThanCount; i++) {
            postpend+= ">";
        }
        return prepend + angles + postpend;
    }

    @Test
    void coforge() {
/*        Leader - if it is greater than sum of  all the elements to its right side.

        {16, 17, 4, 3, 5, 2} --> leaders are 17, 5
 */
        List<Integer> numbers = List.of(54, 17, 4, 8, 5, 2);
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            int otherNumbersSum = 0;
            for (int j = i+1; j < numbers.size(); j++) {
                otherNumbersSum += numbers.get(j);
            }
            if (number > otherNumbersSum && i != numbers.size() -1) {
                System.out.println(number + ": IS A LEADER");
            }
        }

    }
}
