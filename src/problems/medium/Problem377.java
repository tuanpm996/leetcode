package problems.medium;

public class Problem377 {

    public static void main(String[] args) {
        int i = combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(i);
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int num : nums) {
                if (num + i <= target) {
                    dp[num + i] += dp[i];
                }
            }
        }
        return dp[target];
    }
}
