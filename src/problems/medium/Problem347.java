package problems.medium;

import java.util.*;

public class Problem347 {

    public static void main(String[] args) {
        int[] ints = new Problem347().topKFrequent(new int[]{1}, 1);
        System.out.println(Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num : nums) {
            num2Count.put(num, num2Count.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> count2nums = new TreeMap<>(Comparator.comparingInt(t -> (int) t).reversed());
        for (Map.Entry<Integer, Integer> entry : num2Count.entrySet()) {
            List<Integer> numList = count2nums.getOrDefault(entry.getValue(), new ArrayList<>());
            numList.add(entry.getKey());
            count2nums.put(entry.getValue(), numList);
        }
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            Map.Entry<Integer, List<Integer>> entry = count2nums.pollFirstEntry();
            List<Integer> numList = entry.getValue();
            for (Integer num : numList) {
                res[i] = num;
                i++;
            }
        }
        return res;
    }

}
