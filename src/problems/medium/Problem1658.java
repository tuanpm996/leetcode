package problems.medium;

import java.util.Arrays;

public class Problem1658 {

    public int minOperations(int[] nums, int x) {
        int result = Integer.MAX_VALUE;
        int[] sums1 = new int[nums.length + 1];
        sums1[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums1[i] = sums1[i - 1] + nums[i - 1];
        }
        int[] sums2 = new int[nums.length + 1];
        sums2[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums2[i] = sums2[i - 1] + nums[nums.length - i];
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (sums1[i] >= x) {
                if (sums1[i] == x) {
                    result = Math.min(result, i);
                }
                continue;
            }
            int remain = x - sums1[i];
            int pos = Arrays.binarySearch(sums2, remain);
            if (pos > 0 && i + pos <= nums.length) {
                result = Math.min(result, i + pos);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }


    public static void main(String[] args) {
        int i = new Problem1658().minOperations(new int[]{1, 1}, 3);
        System.out.println(i);
    }
}
