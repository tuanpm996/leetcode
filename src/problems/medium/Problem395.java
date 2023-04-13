package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem395 {

    public static void main(String[] args) {
        int aaabb = new Problem395().longestSubstring("aaabb", 3);
        System.out.println(aaabb);
    }

    public int longestSubstring(String s, int k) {
        int left = 0;
        Map<Character, Integer> char2Freq = new HashMap<>();
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            loop:
            while (left < right) {
                if (char2Freq.get(s.charAt(left)) == 1) {
                    char2Freq.remove(s.charAt(left));
                } else {
                    char2Freq.put(s.charAt(left), char2Freq.get(s.charAt(left)) - 1);
                }
                if (char2Freq.size() > 0 && checkIfOk(char2Freq, k)) {
                    break loop;
                }
                left++;
            }
            char2Freq.putIfAbsent(s.charAt(right), 0);
            char2Freq.put(s.charAt(right), char2Freq.get(s.charAt(right)) + 1);
            boolean isOk = checkIfOk(char2Freq, k);
            if (isOk) {
                res = Math.max(res, right - left + 1);
            }
        }

        return 0;
    }

    private boolean checkIfOk(Map<Character, Integer> char2Freq, int k) {
        for (Map.Entry<Character, Integer> entry : char2Freq.entrySet()) {
            Integer value = entry.getValue();
            if (value < k) {
                return false;
            }
        }
        return true;
    }
}
