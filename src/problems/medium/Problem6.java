package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem6 {
    public static void main(String[] args) {
        String pahnaplsiigyir = new Problem6().convert("A", 2);
        System.out.println(pahnaplsiigyir);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int n = 2 * (numRows - 1);
        int mod;
        char[] chars = s.toCharArray();
        int i = 0;
        Map<Integer, StringBuilder> row2Str = new HashMap<>();
        for (int idx = 0; idx < chars.length; idx++) {
            if (!row2Str.containsKey(i)) {
                row2Str.put(i, new StringBuilder());
            }
            row2Str.get(i).append(chars[idx]);
            mod = idx % n;
            if (mod < numRows - 1) {
                i++;
            } else {
                i--;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            if (row2Str.containsKey(k)) {
                stringBuilder.append(row2Str.get(k));
            }
        }
        return stringBuilder.toString();
    }
}
