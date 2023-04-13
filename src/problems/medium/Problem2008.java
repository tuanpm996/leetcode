package problems.medium;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2008 {

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(r -> r[1]));
        long[] dp = new long[rides.length];
        dp[0] = calculateProfit(rides[0]);
        for (int i = 1; i < rides.length; i++) {
            int profit = calculateProfit(rides[i]);
            dp[i] = Math.max(profit, dp[i - 1]);
            int left = 0;
            int right = i - 1;
            int search = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (rides[mid][1] <= rides[i][0]) {
                    search = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (search != -1) {
                dp[i] = Math.max(dp[i], dp[search] + calculateProfit(rides[i]));
            }
        }
        return dp[rides.length - 1];
    }

    int calculateProfit(int[] ride) {
        return ride[1] - ride[0] + ride[2];
    }
}