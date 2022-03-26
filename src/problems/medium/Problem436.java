package problems.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem436 {
    public static void main(String[] args) {
//        [[3,4],[2,3],[1,2]]
        int[][] ints = {
                new int[]{3, 4},
                new int[]{2, 3},
                new int[]{1, 2},
        };
        int[] rightInterval = new Problem436().findRightInterval(ints);
        System.out.println(Arrays.toString(rightInterval));
    }

    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> num2Pos = new HashMap<>();
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            num2Pos.put(intervals[i][0], i);
        }
        int[][] ints = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(ints, Comparator.comparing(t -> t[0]));
        for (int i = 0; i < intervals.length; i++) {
            int l = 0, r = intervals.length - 1;
            boolean found = false;              //to see if result was found
            int min = -1;
            int ep = intervals[i][intervals[0].length - 1];       //ep = endpoint of i
            while (l <= r) {                     //binarySearch on arr of start points
                int mid = (l + ((r - l) / 2));
                if (ints[mid][0] >= ep) {
                    min = ints[mid][0];
                    found = true;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            result[i] = found ? num2Pos.get(min) : -1;
        }
        return result;
    }
}
