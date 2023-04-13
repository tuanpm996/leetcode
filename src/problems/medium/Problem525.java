package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem525 {
    //https://leetcode.com/problems/contiguous-array/description/
    public static void main(String[] args) {
        int res = new Problem525().findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1});
        System.out.println(res);
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sum2FirstPos = new HashMap<>();
        int result = 0;
        sum2FirstPos.put(nums[0] == 0 ? -1 : 1, 0);
        int sum = nums[0] == 0 ? -1 : 1;
        for (int i = 1; i < nums.length; i++) {
            sum = sum + (nums[i] == 0 ? -1 : 1);
            if (sum == 0) {
                result = Math.max(result, i + 1);
            } else if (sum2FirstPos.containsKey(sum)) {
                result = Math.max(result, i - sum2FirstPos.get(sum));
            }
            sum2FirstPos.putIfAbsent(sum, i);
        }
        return result;
    }

}
