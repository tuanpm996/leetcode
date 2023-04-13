package problems.medium;

import java.util.*;

public class Problem438 {
    public static void main(String[] args) {
        List<Integer> anagrams = new Problem438().findAnagrams("abacbabc", "abc");
        System.out.println(Arrays.toString(anagrams.toArray()));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> char2Count = new HashMap<>();
        for (char c : p.toCharArray()) {
            char2Count.put(c, char2Count.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        loop:
        while (i < s.length()) {
            HashMap<Character, Integer> currentMap = new HashMap<>(char2Count);
            char aChar = s.charAt(i);
            if (!currentMap.containsKey(aChar)) {
                i++;
                continue;
            }
            while (i < s.length() && currentMap.containsKey(s.charAt(i))) {
                if (currentMap.get(s.charAt(i)) == 1) {
                    currentMap.remove(s.charAt(i));
                } else {
                    currentMap.put(s.charAt(i), currentMap.get(s.charAt(i)) - 1);
                }
                if (currentMap.isEmpty()) {
                    result.add(i - p.length() + 1);
                    i++;
                    while (i < s.length() && s.charAt(i) == s.charAt(i - p.length())) {
                        result.add(i - p.length() + 1);
                        i++;
                    }
                    continue loop;
                }
                i++;
            }
        }
        return result;
    }

}
