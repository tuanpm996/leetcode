package problems.medium;

public class Problem665 {

    public static void main(String[] args) {
        boolean b = new Problem665().checkPossibility(new int[]{1, 3, 5, 2, 4});
        System.out.println(b);
    }

    public boolean checkPossibility(int[] nums) {
        Integer pos = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (pos != null) {
                    return false;
                }
                pos = i;
            }
        }
        if (pos == null) {
            return true;
        }
        int leftValue = pos - 1 < 0 ? Integer.MIN_VALUE : nums[pos - 1];
        int rightValue = pos + 2 > nums.length - 1 ? Integer.MAX_VALUE : nums[pos + 2];

        return (pos == 0 || leftValue <= nums[pos + 1]) || (pos + 1 == nums.length - 1 || rightValue >= nums[pos]);
    }
}
