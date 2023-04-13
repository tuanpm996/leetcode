package turing;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public static void main(String[] args) {
        int res = new Solution3().findResult("8459761203", "5439");
        System.out.println(res);
    }

    public int findResult(String keyboard, String num) {
        Map<Character, Integer> key2Pos = new HashMap<>();
        char[] charArray = keyboard.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            key2Pos.put(c, i);
        }
        int curr = 0;
        int res = 0;
        for (char c : num.toCharArray()) {
            Integer pos = key2Pos.get(c);
            res += Math.abs(pos - curr);
            curr = pos;
        }
        return res;
    }
}
