package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2461 {

    public static void main(String[] args) {
        long l = new Problem2461().maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3);
        System.out.println(l);
    }

    public long maximumSubarraySum(int[] nums, int k) {
        int left = 0;
        int right = k - 1;
        long result = 0;
        long currentSum = 0;
        Map<Integer, Integer> num2time = new HashMap<>();
        for (int i = 0; i < k; i++) {
            num2time.putIfAbsent(nums[i], 0);
            num2time.put(nums[i], num2time.get(nums[i]) + 1);
            currentSum += nums[i];
        }
        while (left <= nums.length - k && right <= nums.length - 1) {
            if (left > 0) {
                if (num2time.get(nums[left - 1]) == 1) {
                    num2time.remove(nums[left - 1]);
                } else {
                    num2time.put(nums[left - 1], num2time.get(nums[left - 1]) - 1);
                }
                num2time.putIfAbsent(nums[right], 0);
                num2time.put(nums[right], num2time.get(nums[right]) + 1);

                currentSum -= nums[left - 1];
                currentSum += nums[right];
            }
            if (num2time.size() == k) {
                result = Math.max(result, currentSum);
            }
            left++;
            right++;
        }
        return result;
    }
}
