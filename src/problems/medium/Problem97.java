package problems.medium;

import java.util.Arrays;

public class Problem97 {
    public static void main(String[] args) {
        boolean interleave = new Problem97().isInterleave("aabaac", "aadaaeaaf", "aadaaeaabaafaac");
        System.out.println(interleave);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty()) {
            return s2.equals(s3);
        }
        if (s2.isEmpty()) {
            return s1.equals(s3);
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] dp = new int[s2.length() + 1][s1.length() + 1];
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars = s3.toCharArray();
        dp[0][0] = 1;
        for (int i = 1; i < chars1.length + 1; i++) {
            if (chars1[i - 1] == chars[i - 1]) {
                dp[0][i] = Math.min(1, dp[0][i - 1]);
            }
        }

        for (int i = 1; i < chars2.length + 1; i++) {
            if (chars2[i - 1] == chars[i - 1]) {
                dp[i][0] = Math.min(1, dp[i - 1][0]);
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i][j - 1] == 0 && dp[i - 1][j] == 0) {
                    continue;
                }
                if (dp[i][j - 1] == 0) {
                    char c = chars2[i - 1];
                    if (chars[i + j - 1] == c) {
                        dp[i][j] = 1;
                    }
                } else {
                    char c = chars1[j - 1];
                    if (chars[i + j - 1] == c) {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        String string = Arrays.deepToString(dp);
        System.out.println(string);
        return dp[dp.length - 1][dp[0].length - 1] == 1;
    }
}

