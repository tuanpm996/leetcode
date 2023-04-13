package problems.easy;

import java.util.Arrays;

public class Problem1763 {
    public static void main(String[] args) {
        String yazaAay = new Problem1763().longestNiceSubstring("Bb");
        System.out.println(yazaAay);
    }

    public String longestNiceSubstring(String s) {
        char[] chars = s.toCharArray();
        String res = null;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                String substring = s.substring(i, j + 1);
                if (checkIfOk(substring)) {
                    if (res == null || substring.length() > res.length()) {
                        res = substring;
                    }
                }
            }
        }
        return res == null ? "" : res;
    }

    private boolean checkIfOk(String s) {
        int[] uCount = new int[26];
        Arrays.fill(uCount, 0);
        int[] lCount = new int[26];
        Arrays.fill(lCount, 0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a') {
                uCount[s.charAt(i) - 'a']++;
            } else {
                lCount[s.charAt(i) - 'A']++;
            }
        }
        for (int i = 0; i < uCount.length; i++) {
            if (uCount[i] == 0 && lCount[i] != 0) {
                return false;
            }
            if (uCount[i] != 0 && lCount[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
