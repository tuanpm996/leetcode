package problems.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem2085 {
    public static void main(String[] args) {
        int i = new Problem2085().countWords(new String[]{"leetcode", "is", "amazing", "as", "is"}, new String[]{"amazing", "leetcode", "is"});
        System.out.println(i);
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        int count = 0;
        for (String word : words1) {
            if (map1.get(word) == 1 && map2.getOrDefault(word, 0) == 1) {
                count++;
            }
        }
        return count;
    }
}
