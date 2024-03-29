package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem523 {

    public static void main(String[] args) {
        boolean b = new Problem523().checkSubarraySum(new int[]{3, 3}, 3);
        System.out.println(b);
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        // initialize the hash map with index 0 for sum 0
        Map<Integer, Integer> hashMap = new HashMap<>(Map.of(0, 0));
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // if the remainder sum % k occurs for the first time
            if (!hashMap.containsKey(sum % k)) {
                hashMap.put(sum % k, i + 1);
            } else if (hashMap.get(sum % k) < i) {// if the subarray size is at least two
                return true;
            }
        }
        return false;
    }
}
