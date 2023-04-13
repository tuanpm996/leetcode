package problems.medium;

public class Problem713 {

    public static void main(String[] args) {
        int[] ints = {10, 5, 2, 6}; //18
        int i = new Problem713().numSubarrayProductLessThanK(ints, 100);
        System.out.println(i);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) { //from official
        int left = 0;
        int prod = 1;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
