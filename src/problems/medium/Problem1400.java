package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1400 {

    public static void main(String[] args) {
        boolean annabelle = new Problem1400().canConstruct("cr", 7);
        System.out.println(annabelle);
    }

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        Map<Character, Integer> char2Count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!char2Count.containsKey(c)) {
                char2Count.put(c, 1);
            } else {
                char2Count.put(c, char2Count.get(c) + 1);
            }
        }
        return char2Count.values()
                .stream().filter(t -> t % 2 == 1)
                .count() <= k;
    }

    private boolean canConstruct2(String s, int k, Map<String, Boolean> key2Val) {
        String key = s + "|" + k;
        if (key2Val.containsKey(key)) {
            return key2Val.get(key);
        }
        if (s.length() <= 1) {
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (isPalindrome(left) && k >= 1) {
                boolean b = canConstruct2(right, k - 1, key2Val);
                if (b) {
                    key2Val.put(key, true);
                    return true;
                }
            }
        }
        key2Val.put(key, false);
        return false;
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        char[] brokenStr = s.toCharArray();
        Map<Character, Integer> char2Count = new HashMap<>();
        for (int i = 0; i < brokenStr.length; i++) {
            char c = brokenStr[i];
            if (!char2Count.containsKey(c)) {
                char2Count.put(c, 1);
            } else {
                char2Count.put(c, char2Count.get(c) + 1);
            }
        }
        long count = char2Count.values().stream()
                .filter(t -> t % 2 == 1)
                .count();
        return count <= 1;

//        if (s.length() <= 1) {
//            return true;
//        }
//        for (int i = 0; i <= s.length() / 2; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
//                return false;
//            }
//        }
//        return true;
    }
}
