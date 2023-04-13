package problems.medium;

public class Problem983 {

    //Minimum Cost For Tickets
    public static void main(String[] args) {
        int i = minCostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15});
        System.out.println(i);
    }

    public static int minCostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] isTravel = new boolean[lastDay + 1];
        for (int day : days) {
            isTravel[day] = true;
        }

        for (int i = 1; i <= lastDay; i++) {
            if (!isTravel[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            int result = Math.min(dp[i - 1] + costs[0], dp[Math.max(i - 7, 0)] + costs[1]);
            dp[i] = Math.min(result, dp[Math.max(i - 30, 0)] + costs[2]);
        }
        return dp[lastDay];
    }
}
