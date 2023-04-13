package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem930 {

    public static void main(String[] args) {
        int i = new Problem930().numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0);
        System.out.println(i);
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> hash = new HashMap<>(Map.of(0, 1));
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (hash.get(sum - goal) != null) {
                count += hash.get(sum - goal);
            }
            hash.put(sum, hash.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
