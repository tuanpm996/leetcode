package problems.medium;

public class Problem1891 {
    //    https://leetcode.com/problems/cutting-ribbons/

    public static void main(String[] args) {
        int maxLength = new Problem1891().maxLength(new int[]{9,7,5}, 3);
        System.out.println(maxLength);
    }

    public int maxLength(int[] ribbons, int k) {
        int right = Integer.MIN_VALUE;
        for (int ribbon : ribbons) {
            right = Math.max(ribbon, right);
        }
        int left = 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int ribbon : ribbons) {
                count += Math.floor((double) ribbon / mid);
            }
            if (count == k) {
                int count2 = 0;
                for (int ribbon : ribbons) {
                    count2 += Math.floor((double) ribbon / mid + 1);
                }
                if (count2 >= k) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (count > k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
