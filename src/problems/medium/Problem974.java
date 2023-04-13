package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem974 {
    //https://leetcode.com/problems/subarray-sums-divisible-by-k/solutions/2913063/subarray-sums-divisible-by-k/
    public static void main(String[] args) {
        int res = new Problem974().subarraysDivByK(new int[]{8, 9, 7, 8, 9}, 8);
        System.out.println(res);
    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> mod2Count = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            int mod = num % k + (num < 0 ? k : 0);
            sum += mod;
            int sumMod = sum % k;
            if (sumMod == 0) {
                res++;
            }
            if (mod2Count.containsKey(sumMod)) {
                res += mod2Count.get(sumMod);
            }
            mod2Count.put(sumMod, mod2Count.getOrDefault(sumMod, 0) + 1);
        }
        return res;
    }
}
