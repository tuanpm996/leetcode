package problems.medium;

public class Problem376 {
    public static void main(String[] args) {
        int[] ints = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int i = new Problem376().wiggleMaxLength(ints);
        System.out.println(i);
    }

    public int wiggleMaxLength(int[] nums) {
        int[] data = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            data[i] = nums[i + 1] - nums[i] > 0 ? 1 : -1;
        }
        int[] dp = new int[data.length];

        int max = 0;
        dp[0] = data[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = (data[i] + data[i - 1]) == 0 ? dp[i - 1] + 1 : 1;
            max = Math.max(dp[i], max);
        }
        return max + 1;
    }
}
