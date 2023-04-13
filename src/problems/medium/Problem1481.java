package problems.medium;

import java.util.*;

public class Problem1481 {
    // https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/
    public static void main(String[] args) {
        int leastNumOfUniqueInts = new Problem1481().findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3);
        System.out.println(leastNumOfUniqueInts);
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        PriorityQueue<Integer> pq = new PriorityQueue<>(count.values());
        while (k > 0) {
            k -= pq.poll();
        }
        return k < 0 ? pq.size() + 1 : pq.size();
    }


}
