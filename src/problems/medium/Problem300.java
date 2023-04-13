package problems.medium;

public class Problem300 {
    public static void main(String[] args) {
        int i = lengthOfLIS2(new int[]{12, 16, 18, 13, 14, 15, 11});
        System.out.println(i);
    }


    public static int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    //O(n2)
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else {
                int maxJ = -1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        maxJ = Math.max(dp[j], maxJ);
                    }
                }
                dp[i] = maxJ < 0 ? 1 : maxJ + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
