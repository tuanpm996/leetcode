package problems.medium;

public class Problem209 {

    public static void main(String[] args) {
        int i = new Problem209().minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1});
        System.out.println(i);
    }

    private int minSubArrayLen(int i, int[] ints) {
        return 0;
    }

    public int minSubArrayLen2(int target, int[] nums) { //2 pointers
        int left = 0;
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        int sum = nums[0];
        int right = 0;
        while (left < n && right < n) {
            if (sum >= target) {
                result = Math.min(right - left + 1, result);
                sum = sum - nums[left];
                left++;
            } else {
                if (right + 1 < n) {
                    sum += nums[right + 1];
                }
                right++;
            }
        }
        return result < Integer.MAX_VALUE ? result : 0;
    }
}
