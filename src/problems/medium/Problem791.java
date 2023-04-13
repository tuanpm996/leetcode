package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem791 {

    public static void main(String[] args) {
        String s = new Problem791().customSortString("kqep", "pekeq");
        System.out.println(s);
    }

    public String customSortString(String order, String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> char2Count = new HashMap<>();
        for (char aChar : chars) {
            char2Count.put(aChar, char2Count.getOrDefault(aChar, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (!char2Count.containsKey(c)) {
                continue;
            }
            Integer count = char2Count.get(c);
            sb.append(String.valueOf(c).repeat(Math.max(0, count)));
            char2Count.remove(c);
        }
        for (Map.Entry<Character, Integer> entry : char2Count.entrySet()) {
            Character aChar = entry.getKey();
            Integer value = entry.getValue();
            sb.append(String.valueOf(aChar).repeat(Math.max(0, value)));
        }
        return sb.toString();
    }
}
