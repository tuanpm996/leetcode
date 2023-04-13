package problems.medium;

public class Problem376 {
    public static void main(String[] args) {
        int[] ints = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int i = new Problem376().wiggleMaxLength(ints);
        System.out.println(i);
    }

    public int wiggleMaxLength(int[] nums) {
        int i = 1;
        while (i < nums.length && nums[i] == nums[i - 1]) {
            i++;
        }
        int count = 0;
        boolean up = nums[i] - nums[i - 1] > 0;
        while (i < nums.length) {
            if (up && nums[i] - nums[i - 1] < 0) {
                up = false;
                count++;
            }
            if (!up && nums[i] - nums[i - 1] > 0) {
                up = true;
                count++;
            }
            i++;
        }

        return count + 2;
    }

}
