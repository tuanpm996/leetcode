package problems.medium;

import java.util.Arrays;
import java.util.Comparator;

public class Problem646 {

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;
    }
}
