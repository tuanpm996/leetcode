package problems.medium;

public class Problem518 {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i == 0) {
                    dp[j][i] = 1;
                } else {
                    if (j == 0) {
                        dp[j][i] += i % coin == 0 ? 1 : 0;
                    } else {
                        dp[j][i] += dp[j - 1][i];
                        if (coin <= i) {
                            dp[j][i] += dp[j][i - coin];
                        }
                    }
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

    public static void main(String[] args) {
        int change = new Problem518().change(500, new int[]{1, 2, 5});
        System.out.println(change);
    }
}
