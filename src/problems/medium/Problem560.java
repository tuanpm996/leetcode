package problems.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class Problem560 {

    public static void main(String[] args) {
        int res = new Problem560().subarraySum(new int[]{-1, -1, 1}, 0);
        System.out.println(res);
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (hash.get(sum - k) != null) {
                count += hash.get(sum - k);
            }
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
