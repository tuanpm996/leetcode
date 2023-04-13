package problems.easy;

import java.util.*;

public class Problem575 {
    public static void main(String[] args) {
        int res = new Problem575().distributeCandies(new int[]{6, 6, 6, 6});
        System.out.println(res);
    }

    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> candyType2count = new HashMap<>();
        for (int candy : candies) {
            candyType2count.put(candy, candyType2count.getOrDefault(candy, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = candyType2count.entrySet();
        int k = candies.length / 2;
        for (Map.Entry<Integer, Integer> entry : entries) {
            k = Math.max(0, k - entry.getValue() + 1);
        }
        return entries.size() - k;
    }
}
