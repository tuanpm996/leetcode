package problems.medium;

import java.util.Arrays;

public class Problem34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int leftIdx = -1;
        loop:
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == left) {
                    leftIdx = left;
                    break loop;
                }
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (leftIdx == -1 && right >= 0 && nums[right] == target) {
            leftIdx = right;
        }
        if (leftIdx == -1) {
            return new int[]{-1, -1};
        }

        int rightIdx = -1;
        left = 0;
        right = n - 1;
        loop2:
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid == left && nums[mid + 1] == target) {
                    rightIdx = right;
                    break loop2;
                }
                if (mid == left && nums[mid] == target) {
                    rightIdx = left;
                    break loop2;
                }
                left = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (rightIdx == -1 && left >= 0 && nums[left] == target) {
            rightIdx = left;
        }
        return new int[]{leftIdx, rightIdx};
    }


    public static void main(String[] args) {
        int[] ints = new Problem34().searchRange(new int[]{2, 2}, 1);
        System.out.println(Arrays.toString(ints));
    }
}
