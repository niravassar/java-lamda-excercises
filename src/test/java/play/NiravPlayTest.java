package play;

import org.apache.commons.lang3.ArrayUtils;
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
    }

    private long solution1(long[] numbers) {
        Long[] longObjects = ArrayUtils.toObject(numbers);
        List<Long> myList = new ArrayList<>(List.of(longObjects));
        return myList.stream().max(Long::compareTo).orElse(0L);
    }
}
