package turing;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        int[] repeat = new Solution().findRepeat(new int[]{1, 2, 2});
        System.out.println(Arrays.toString(repeat));
    }

    public int[] findRepeat(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(i + 1);
        }
        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num : arr) {
            num2Count.put(num, num2Count.getOrDefault(num, 0) + 1);
            set.remove(num);
        }
        int num = 0;
        for (Map.Entry<Integer, Integer> entry : num2Count.entrySet()) {
            if (entry.getValue() > 1) {
                num = entry.getKey();
            }
        }
        ArrayList<Integer> integers = new ArrayList<>(set);
        return new int[]{num, integers.get(0)};


    }
}
