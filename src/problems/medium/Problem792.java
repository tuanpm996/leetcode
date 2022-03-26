package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem792 {
    public static void main(String[] args) {
        String s = "abcde";
        String[] strings = {"a", "bb", "acd", "ace"};
//        String[] strings = {"ace"};
        int i = new Problem792().numMatchingSubseq(s, strings);
        System.out.println(i);
    }

    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<String, Boolean> key2isContain = new HashMap<>();
        for (String word : words) {
            if (isAWord(word, s, key2isContain)) {
                count++;
            }
        }
        return count;
    }

    private boolean isAWord(String word, String s, Map<String, Boolean> key2isContain) {
        String key = String.format("%s|%s", word, s);
        if (key2isContain.containsKey(key)) {
            return key2isContain.get(key);
        }
        if(word.length() > s.length()) {
            key2isContain.put(key, false);
            return false;
        }
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            char c = word.charAt(0);
            boolean isOn = isOnWord(c, left);
            if (isOn) {
                String right = s.substring(i);
                if (word.substring(1).isEmpty()) {
                    key2isContain.put(key, true);
                    return true;
                }
                boolean aWord = isAWord(word.substring(1), right, key2isContain);
                key2isContain.put(key, aWord);
                return aWord;
            }
        }
        key2isContain.put(key, false);
        return false;
    }

    private boolean isOnWord(char c, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }
}
