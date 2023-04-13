package problems.medium;

import java.util.Arrays;

public class Problem494 {

    int total;

    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();

        int[][] memo = new int[nums.length][2 * total + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return calculate(nums, 0, 0, target, memo);
    }

    public int calculate(int[] nums, int i, int sum, int target, int[][] memo) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        if (memo[i][sum + total] != Integer.MIN_VALUE) {
            return memo[i][sum + total];
        }
        int add = calculate(nums, i + 1, sum + nums[i], target, memo);
        int subtract = calculate(nums, i + 1, sum - nums[i], target, memo);
        memo[i][sum + total] = add + subtract;
        return memo[i][sum + total];
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 1, 1};
        int targetSumWays = new Problem494().findTargetSumWays(ints, 3);
        System.out.println(targetSumWays);
    }
}
