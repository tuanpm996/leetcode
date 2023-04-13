package problems.medium;

import java.util.Arrays;

public class Problem475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = 0;

        loop:
        for (int house : houses) {
            int left = 0;
            int right = heaters.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (heaters[mid] == house) {
                    continue loop;
                } else if (heaters[mid] > house) {
                    if (mid - 1 >= 0 && heaters[mid - 1] == house) {
                        continue loop;
                    } else if (mid - 1 >= 0 && heaters[mid - 1] < house) {
                        result = Math.max(result, Math.min(heaters[mid] - house, house - heaters[mid - 1]));
                        continue loop;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid + 1 < heaters.length && heaters[mid + 1] == house) {
                        continue loop;
                    } else if (mid + 1 < heaters.length && heaters[mid + 1] > house) {
                        result = Math.max(result, Math.min(heaters[mid + 1] - house, house - heaters[mid]));
                        continue loop;
                    } else {
                        left = mid + 1;
                    }
                }
            }
            int subResult = Integer.MAX_VALUE;
            if (left >= 0 && left < heaters.length) {
                subResult = Math.min(Math.abs(heaters[left] - house), subResult);
            }
            if (right >= 0) {
                subResult = Math.min(Math.abs(heaters[right] - house), subResult);
            }
            if (subResult < Integer.MAX_VALUE) {
                result = Math.max(subResult, result);
            }
        }
        return result;

    }

    public static void main(String[] args) {

//        int i = Arrays.binarySearch(new int[]{1, 2, 4, 5}, 0, 4, 1);
//        int i1 = Arrays.binarySearch(new int[]{1, 2, 4, 5}, 0, 4, 5);
//        int i2 = Arrays.binarySearch(new int[]{1, 2, 4, 5}, 0, 4, 3);
//        System.out.println(i + " " + i1 + " " + i2);
        int radius = new Problem475().findRadius(new int[]{1, 2, 3}, new int[]{2});
        System.out.println(radius);
    }


}
