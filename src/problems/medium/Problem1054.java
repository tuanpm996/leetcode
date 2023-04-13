package problems.medium;

import java.util.*;

public class Problem1054 {

    public static void main(String[] args) {
        int[] ints = new Problem1054().rearrangeBarcodes(new int[]{3, 7, 3, 7, 7, 7, 7, 2, 2, 2});
        System.out.println(Arrays.toString(ints));
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num : barcodes) {
            num2Count.put(num, num2Count.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> count2nums = new TreeMap<>(Comparator.comparingInt(t -> (int) t).reversed());
        for (Map.Entry<Integer, Integer> entry : num2Count.entrySet()) {
            List<Integer> numList = count2nums.getOrDefault(entry.getValue(), new ArrayList<>());
            numList.add(entry.getKey());
            count2nums.put(entry.getValue(), numList);
        }
        int[] res = new int[barcodes.length];

        Set<Integer> integers = count2nums.keySet();
        int i = 0;
        while (i < barcodes.length) {
            loop:
            for (Integer count : integers) {
                List<Integer> list = count2nums.get(count);
                for (Integer num : list) {
                    if (num2Count.containsKey(num) && (i == 0 || res[i - 1] != num)) {
                        res[i] = num;
                        if (num2Count.get(num) == 1) {
                            num2Count.remove(num);
                        } else {
                            num2Count.put(num, num2Count.get(num) - 1);
                        }
                        i++;
                        continue loop;
                    }
                }
            }
        }
        return res;
    }

}
