package problems.medium;

import java.util.*;

public class Problem2121 {
    public static void main(String[] args) {
        long[] distances = new Problem2121().getDistances(new int[]{2, 1, 3, 1, 2, 3, 3});
        System.out.println(Arrays.toString(distances));

    }
    // https://leetcode.com/problems/intervals-between-identical-elements/

    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> num2Positions = new HashMap<>();
        long[] distances = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            List<Integer> orDefault = num2Positions.getOrDefault(arr[i], new ArrayList<>());
            orDefault.add(i);
            num2Positions.put(arr[i], orDefault);
        }
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = num2Positions.get(arr[i]);
            for (Integer integer : list) {
                if (integer == i || arr[i] != arr[integer]) {
                    continue;
                }
                distances[i] += Math.abs(i - integer);
            }
        }
        return distances;
    }
}
