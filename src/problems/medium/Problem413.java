package problems.medium;

public class Problem413 {

    public static void main(String[] args) {
        int i = new Problem413().numberOfArithmeticSlices(new int[]{7, 7, 7, -2, 7, 7, 7, 7, 7, 7});
        System.out.println(i);

    }


    public int numberOfArithmeticSlices(int[] nums) {
        int left = 0;
        int count = 0;
        int currentSub;
        int right = 0;
        while (right < nums.length) {
            while (left < right) {
                left++;
            }
            if (right + 1 >= nums.length) {
                right++;
                continue;
            }
            currentSub = nums[right + 1] - nums[right];
            while (right + 1 < nums.length && nums[right + 1] - nums[right] == currentSub) {
                right++;
            }
            if (right - left + 1 >= 3) {
                int size = right - left + 1;
                count += (size - 2) * (size - 1) / 2;
            }
        }
        return count;
    }
}
