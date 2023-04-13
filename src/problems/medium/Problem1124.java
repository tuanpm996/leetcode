package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1124 {
    public static void main(String[] args) {
//        int i = new Problem1124().longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9, 9, 6, 6, 9, 9});
        int i = new Problem1124().longestWPI(new int[]{6, 6, 9, 9, 6, 6, 9, 9});
        System.out.println(i);
    }

    public int longestWPI(int[] hours) {
        Map<Integer, Integer> score2FirstPos = new HashMap<>();
        int score = 0;
        int res = 0;
        for (int i = 0; i < hours.length; i++) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                score2FirstPos.putIfAbsent(score, i);
                if (score2FirstPos.containsKey(score - 1)) {
                    res = Math.max(res, i - score2FirstPos.get(score - 1));
                }
            }
        }
        return res;
    }
}
