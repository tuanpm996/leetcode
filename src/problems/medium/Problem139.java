package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem139 {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> strings = new ArrayList<>() {{
            add("leet");
            add("code");
        }};
        boolean b = new Problem139().wordBreak(s, strings);
        System.out.println(b);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> string2IsInDict = new HashMap<>();
        return wordBreak2(s, wordDict, string2IsInDict);
    }

    public boolean wordBreak2(String s, List<String> wordDict, Map<String, Boolean> string2IsInDict) {
        if (string2IsInDict.containsKey(s)) {
            return string2IsInDict.get(s);
        }
        if (wordDict.contains(s)) {
            string2IsInDict.put(s, true);
            return true;
        }
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (isOnDictionary(left, wordDict)) {
                boolean isOnDict = wordBreak2(right, wordDict, string2IsInDict);
                if (isOnDict) {
                    string2IsInDict.put(s, true);
                    return true;
                }
            }
        }
        string2IsInDict.put(s, false);
        return false;
    }

    private boolean isOnDictionary(String s, List<String> wordDict) {
        return wordDict.contains(s);
    }
}
