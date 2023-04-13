package problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2516 {

    public static void main(String[] args) {
//        int aabaaaacaabc = new Problem2516().takeCharacters("abc", 1);
//        int aabaaaacaabc = new Problem2516().takeCharacters("aabaaaacaabc", 2);
//        int aabaaaacaabc = new Problem2516().takeCharacters("cbbac", 1);
        int aabaaaacaabc = new Problem2516().takeCharacters("ccbabcc", 1);
        System.out.println(aabaaaacaabc);
    }


    public int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        int leftStep = 0;
        int rightStep = 0;
        int same = 0;
        Map<Character, Integer> char2Num = new HashMap<>();
        while (left <= right) {
            char leftChar = chars[left];
            if ((!char2Num.containsKey(leftChar) || char2Num.get(leftChar) < k) && chars[left] == chars[right]) {
                if (left == right) {
                    return leftStep + rightStep - same;
                }
                char2Num.put(leftChar, char2Num.getOrDefault(leftChar, 0) + 1);
                leftStep = left + 1;
                left++;
                rightStep = chars.length - right;
                right--;
                same++;
                if (isOk(char2Num, k)) {
                    return leftStep + rightStep - same;
                }
            } else if (!char2Num.containsKey(leftChar) || char2Num.get(leftChar) < k) {
                char2Num.put(leftChar, char2Num.getOrDefault(leftChar, 0) + 1);
                leftStep = left + 1;
                left++;
                if (isOk(char2Num, k)) {
                    return leftStep + rightStep - same;
                }
            } else if (!char2Num.containsKey(chars[right]) || char2Num.get(chars[right]) < k) {
                char2Num.put(chars[right], char2Num.getOrDefault(chars[right], 0) + 1);
                rightStep = chars.length - right;
                right--;
                if (isOk(char2Num, k)) {
                    return leftStep + rightStep - same;
                }
            } else {
                left++;
                right--;
            }
        }
        return -1;
    }

    boolean isOk(Map<Character, Integer> char2Num, int k) {
        for (Character character : Arrays.asList('a', 'b', 'c')) {
            if (!char2Num.containsKey(character)) {
                return false;
            }
            if (char2Num.get(character) < k) {
                return false;
            }
        }

        return true;
    }
}
