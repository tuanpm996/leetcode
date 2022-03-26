package problems.medium;

import java.util.Arrays;

public class Problem74 {
    public static void main(String[] args) {
//        [1,3,5,7],[10,11,16,20],[23,30,34,6
        int[][] ints = {
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60},
        };
        boolean b = new Problem74().searchMatrix(ints, 100);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (ints[0] <= target && ints[ints.length - 1] >= target) {
                int i = Arrays.binarySearch(ints, target);
                if (i >= 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
