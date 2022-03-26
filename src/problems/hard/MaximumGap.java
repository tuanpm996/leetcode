package problems.hard;

import java.util.Arrays;

public class MaximumGap {
    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        int[] arr = new int[]{
                1, 3, 6, 9
        };
        int i = maximumGap.maximumGap(arr);
        System.out.println("max gap: " + i);
    }

    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxGap = 0;
        if (nums.length == 1) {
            maxGap = 0;
        } else {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] > maxGap) {
                    maxGap = nums[i + 1] - nums[i];
                }
            }
        }
        return maxGap;
    }
}
