package problems.medium;

import java.util.Arrays;
import java.util.Random;

public class Problem33 {

    public static void main(String[] args) {
        int result = new Problem33().search(new int[]{5, 1, 2, 3, 4}, 1);
//        int result = new Problem33().search(new int[]{0, 1, 2, 4, 5, 6, 7}, 0);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        //find rotated position
        int rotatedPos = findRotatedPosition(nums);
        if (rotatedPos == nums.length - 1) {
            int i = Arrays.binarySearch(nums, target);
            return i >= 0 ? i : -1;
        }
        if (target <= nums[nums.length - 1]) {
            int[] ints = Arrays.copyOfRange(nums, rotatedPos + 1, nums.length);
            int i = Arrays.binarySearch(ints, target);
            return i >= 0 ? i + rotatedPos + 1 : -1;
        }

        int[] ints = Arrays.copyOfRange(nums, 0, rotatedPos + 1);
        int i = Arrays.binarySearch(ints, target);
        return i >= 0 ? i : -1;
    }

    private int findRotatedPosition(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                return left;
            }
            int mid = (left + right) / 2;
            if (left == mid) {
                return nums[left] > nums[right] ? left : right;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return mid - 1;
            }
            if (nums[mid] < nums[left]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


}
