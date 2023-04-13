package problems.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1590 {
    public static void main(String[] args) {
        int res = new Problem1590().minSubarray(new int[]{8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2}, 148);
        System.out.println(res);
//        new Problem1590().test(new int[]{8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2}, 148);
    }

    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int mod = (int) (sum % p);
        if (mod == 0) {
            return 0;
        }
        sum = 0;
        Map<Integer, Integer> mod2LastPos = new HashMap<>();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum % p == mod) {
                res = Math.min(i + 1, res);
            }
            if (nums[i] % p == mod) {
                return 1;
            }
            int currentMod = (int) (sum % p >= 0 ? sum % p : sum % p + p);
            if (mod2LastPos.containsKey(currentMod - mod)) {
                res = Math.min(res, i - mod2LastPos.get(currentMod - mod));
            } else if (mod2LastPos.containsKey(currentMod - mod + p)) {
                res = Math.min(res, i - mod2LastPos.get(currentMod - mod + p));
            }
            mod2LastPos.put(currentMod, i);
        }
        return res < nums.length ? res : -1;
    }

    public void test(int[] arr, int p) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int[] ints = new int[arr.length];
        ints[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ints[i] = ints[i - 1] + arr[i];
        }
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length; j++) {
                int res = 0;
                if (i == 0) {
                    res = ints[j];
                } else {
                    res = ints[j] - ints[i - 1];
                }
                System.out.println(i + " " + j + " =>" + (sum - res) % p);
            }
        }

    }
}
