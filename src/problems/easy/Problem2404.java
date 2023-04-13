package problems.easy;

import java.util.Map;
import java.util.TreeMap;

public class Problem2404 {

    public static void main(String[] args) {
        int i = new Problem2404().mostFrequentEven(new int[]{4, 4, 4, 9, 2, 4});
        System.out.println(i);
    }

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> num2freq = new TreeMap<>();
        for (int num : nums) {
            num2freq.putIfAbsent(num, 0);
            num2freq.put(num, num2freq.get(num) + 1);
        }
        int maxValue = 0;
        int result = -1;
        for (Map.Entry<Integer, Integer> entry : num2freq.entrySet()) {
            Integer value = entry.getValue();
            if (value > maxValue && entry.getKey() % 2 == 0) {
                maxValue = value;
                result = entry.getKey();
            }
        }
        return result;
    }

}
