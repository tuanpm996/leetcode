package problems.medium;

public class Problem978 {

    public static void main(String[] args) {
        int i = new Problem978().maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9});
        System.out.println(i);
    }

    public int maxTurbulenceSize(int[] arr) { //copy from official solution
        int anchor = 0;
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int c = Integer.compare(arr[i - 1], arr[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == arr.length - 1 || c * Integer.compare(arr[i], arr[i + 1]) != -1) {
                res = Math.max(res, i - anchor + 1);
                anchor = i;
            } else {
                System.out.println("i:" + i + " anchor:" + anchor);
            }
        }
        return res;
    }
}
