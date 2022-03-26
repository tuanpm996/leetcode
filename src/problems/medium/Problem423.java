package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem423 {

    public static void main(String[] args) {
        String owoztneoer = new Problem423().originalDigits("zerozero");
        System.out.println(owoztneoer);
    }

    public String originalDigits(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        Map<Character, Integer> char2Count = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!char2Count.containsKey(c)) {
                char2Count.put(c, 1);
            } else {
                char2Count.put(c, char2Count.get(c) + 1);
            }
        }
        while (char2Count.size() > 0) {
            for (int i = 0; i < strings.length; i++) {
                String string = strings[i];
                char[] chars = string.toCharArray();
                if (isContain(chars, char2Count)) {
                    for (char c : chars) {
                        if (char2Count.get(c) - 1 > 0) {
                            char2Count.put(c, char2Count.get(c) - 1);
                        } else {
                            char2Count.remove(c);
                        }
                    }
                    stringBuilder.append(i);

                }
            }
        }
        return stringBuilder.toString();
    }

    private boolean isContain(char[] chars, Map<Character, Integer> map) {
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                return false;
            }
        }
        return true;
    }

}
