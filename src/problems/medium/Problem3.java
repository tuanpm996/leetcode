package problems.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public static void main(String[] args) {
        int abcabcbb = new Problem3().lengthOfLongestSubstring("pwwkew");
        System.out.println(abcabcbb);
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char aChar : chars) {
            if (set.contains(aChar)) {
                int size = set.size();
                max = Math.max(size, max);
                set.clear();
            } else {
                set.add(aChar);
            }
        }
        return max;
    }
}
