package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1027 {
    public static void main(String[] args) {
        int res = new Problem1027().longestArithSeqLength(new int[]{3, 6, 9, 12});
        System.out.println(res);
    }

    public int longestArithSeqLength(int[] A) {
        int res = 2;
        int n = A.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}

