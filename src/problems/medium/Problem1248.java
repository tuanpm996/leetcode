package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1248 {
    public static void main(String[] args) {
        int res = new Problem1248().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);
        System.out.println(res);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> pos2Count = new HashMap<>();
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num % 2 == 1) {
                count++;
            }
            pos2Count.put(i, count);
        }
        Map<Integer, List<Integer>> count2Positions = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : pos2Count.entrySet()) {
            List<Integer> posList = count2Positions.getOrDefault(entry.getValue(), new ArrayList<>());
            posList.add(entry.getKey());
            count2Positions.put(entry.getValue(), posList);
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num % 2 == 1) {
                count++;
            }
            if (count == k) {
                res++;
            }
            if (count2Positions.containsKey(count - k)) {
                List<Integer> posList = count2Positions.get(count - k);
                for (Integer pos : posList) {
                    if (pos < i) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
