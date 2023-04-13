package problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Problem389 {

    public static void main(String[] args) {
        char theDifference = new Problem389().findTheDifference("a", "aa");
        System.out.println(theDifference);
    }

    public char findTheDifference(String s, String t) {
        Map<Integer, Integer> char2countS = new HashMap<>();
        for (int aChar : s.chars().toArray()) {
            char2countS.put(aChar, char2countS.getOrDefault(aChar, 0) + 1);
        }


        Map<Integer, Integer> char2countT = new HashMap<>();
        for (int aChar : t.chars().toArray()) {
            char2countT.put(aChar, char2countT.getOrDefault(aChar, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : char2countT.entrySet()) {
            if (!char2countS.containsKey(entry.getKey()) || !Objects.equals(char2countS.get(entry.getKey()), entry.getValue())) {
                return (char) entry.getKey().intValue();
            }
        }
        return 't';
    }
}
