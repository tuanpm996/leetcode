package problems.easy;

import java.util.Arrays;

public class Problem1984 {
    public static void main(String[] args) {
        int i = new Problem1984().minimumDifference(new int[]{9, 4, 1, 7}, 2);
        System.out.println(i);

    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = k - 1;
        int result = Integer.MAX_VALUE;
        while (left <= nums.length - k) {
            result = Math.min(nums[right++] - nums[left++], result);
        }
        return result;
    }
}
