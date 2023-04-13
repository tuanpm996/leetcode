package problems.medium;

public class Problem2414 {

    public static void main(String[] args) {
        int i = new Problem2414().longestContinuousSubstring("abcde");
        System.out.println(i);
    }

    public int longestContinuousSubstring(String s) {
        int left = 0;
        int result = 0;
        for (int right = 0; right < s.length(); right++) {
            while (left < right) {
                left++;
            }
            while (right + 1 < s.length() && s.charAt(right) == s.charAt(right + 1) - 1) {
                right++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
