package problems.medium;

public class Problem1343 {

    public static void main(String[] args) {
        int i = new Problem1343().numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5);
        System.out.println(
                i
        );
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int right = k - 1;
        int count = 0;
        int prod = threshold * k;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        while (left <= arr.length - k) {
            if (left > 0) {
                sum = sum - arr[left - 1] + arr[right];
            }
            if (sum >= prod) {
                count++;
            }
            left++;
            right++;
        }
        return count;
    }
}
