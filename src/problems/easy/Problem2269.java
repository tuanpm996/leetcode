package problems.easy;

public class Problem2269 {

    public static void main(String[] args) {
        int i = new Problem2269().divisorSubstrings(430043, 2);
        System.out.println(i);
    }

    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        int left = 0;
        int right = k - 1;
        int result = 0;
        while (left <= s.length() - k) {
            String substring = s.substring(left++, right++ + 1);
            int i = Integer.parseInt(substring);
            if (i > 0 && num % i == 0) {
                result++;
            }
        }
        return result;
    }
}
