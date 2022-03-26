package problems.medium;

import java.util.Map;
import java.util.TreeMap;

public class Problem846 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        new Problem846().isNStraightHand(ints, 3);
    }



    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (Integer i : map.keySet()) {
            int count = map.get(i);
            if (count == 0) {
                continue;
            }
            for (int j = i; j < i + groupSize; j++) {
                Integer c = map.get(j);
                if (c == null || c < count) {
                    return false;
                }
                map.put(j, c - count);
            }
        }
        return true;
    }
}
