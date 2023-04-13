package problems.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem658 {
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        int left = 0;
        int right = k - 1;
        int[] ints = null;
        loop:
        while (left <= arr.length - k) {
            int leftValue = Math.abs(arr[left] - x);
            if (right + 1 < arr.length && arr[right + 1] != arr[left] && leftValue <= Math.abs(arr[right + 1] - x)) {
                ints = Arrays.copyOfRange(arr, left, right + 1);
                break loop;
            }
            left++;
            right++;
        }
        if (ints == null) {
            ints = Arrays.copyOfRange(arr, left - 1, right);
        }
        return Arrays.stream(ints).boxed().collect(Collectors.toList());
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int pos = findClosestElement(arr, x);
        int left = Math.max(0, pos - k + 1);
        int right = left + k - 1;
        int[] ints = null;
        loop:
        while (left <= pos && right < arr.length && right + 1 < arr.length) {
            int leftValue = Math.abs(arr[left] - x);
            if (arr[right + 1] != arr[left] && leftValue <= Math.abs(arr[right + 1] - x)) {
                ints = Arrays.copyOfRange(arr, left, right + 1);
                break loop;
            }
            left++;
            right++;
        }
        if (ints == null) {
            ints = Arrays.copyOfRange(arr, left - 1, right);
        }
        return Arrays.stream(ints).boxed().collect(Collectors.toList());
    }

    private int findClosestElement(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid == left) {
                return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
            }
            if (arr[mid] == x) {
                if (mid - 1 >= 0 && arr[mid - 1] == x) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (left < arr.length && right >= 0) {
            return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
        } else if (left < arr.length) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        List<Integer> closestElements = new Problem658().findClosestElements(new int[]{0, 0, 0, 1, 3, 5, 6, 7, 8, 8}, 2, 2);
        System.out.println(Arrays.toString(closestElements.toArray()));
    }
}
