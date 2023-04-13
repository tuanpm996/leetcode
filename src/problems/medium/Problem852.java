package problems.medium;

public class Problem852 {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == 0) {
                return 1;
            }
            if (mid == n - 2) {
                return n - 2;
            }
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = new Problem852().peakIndexInMountainArray(new int[]{0, 1, 2, 5, 7, 10, 9, 8, 7, 5, 2});
        System.out.println(i);
    }
}
