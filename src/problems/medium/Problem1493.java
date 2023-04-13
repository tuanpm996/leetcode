package problems.medium;

public class Problem1493 {
    public static void main(String[] args) {
        int i = new Problem1493().longestSubarray2(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1});
        System.out.println(i);

    }

    public int longestSubarray2(int[] A) { //copy from optimal solution
        int i = 0;
        int j;
        int k = 1;
        int res = 0;
        for (j = 0; j < A.length; ++j) {
            System.out.println("i:" + i + " j:" + j + " k:" + k);
            if (A[j] == 0) {
                System.out.println("i:" + i + " j:" + j + " k:" + k);
                k--;
            }
            while (k < 0) { // exist 0
                if (A[i] == 0) {
                    System.out.println("i:" + i + " j:" + j + " k:" + k);
                    k++;
                }
                System.out.println("i:" + i + " j:" + j + " k:" + k);
                i++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }

    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroPos = -1;
        while (left < nums.length && nums[left] == 0) {
            zeroPos = left++;
        }
        int right = left;
        int zeroCount = 0;
        int result = 0;

        while (right < nums.length) {
            while (nums[left] == 0) {
                left++;
            }
            zeroCount = 0;
            while (right < nums.length && (zeroCount == 0 || nums[right] == 1)) {
                if (nums[right] == 0) {
                    zeroCount = 1;
                }
                boolean hasZero = left <= zeroPos && right >= zeroPos;
                if ((left != 0 || right != nums.length - 1) || hasZero) {
                    result = Math.max(result, right - left + (hasZero ? 0 : 1));
                }
                right++;
            }

        }
        return result;
    }
}
