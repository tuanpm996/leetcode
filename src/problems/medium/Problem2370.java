package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2370 {
    public static void main(String[] args) {
        int acfgbd = new Problem2370().longestIdealString("acfgbd", 2);
        System.out.println(acfgbd);
    }

    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        Map<Integer, Integer> sub2MaxLengthPos = new HashMap<>();
        sub2MaxLengthPos.put(s.charAt(0) - 'a', 1);
        for (int i = 1; i < n; i++) {
            char aChar = s.charAt(i);
            int sub = aChar - 'a';
            dp[i] = dp[i - 1];
            for (int j = -k; j <= k; j++) {
                if (sub2MaxLengthPos.containsKey(sub + j)) {
                    dp[i] = Math.max(dp[i], sub2MaxLengthPos.get(sub + j) + 1);
                }
            }
            if (!sub2MaxLengthPos.containsKey(sub)) {
                sub2MaxLengthPos.put(sub, i);
            } else {
                sub2MaxLengthPos.putIfAbsent(sub, sub2MaxLengthPos.get(sub) + 1);
            }
        }
        return dp[n - 1];
    }
}
