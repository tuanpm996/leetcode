package problems.medium;

public class Problem1423 {

    public static void main(String[] args) {
        int i = new Problem1423().maxScore(new int[]{1, 1000, 1}, 1);
        System.out.println(i);
    }

    public int maxScore(int[] cardPoints, int l) {
        int k = cardPoints.length - l;
        int sum = 0;
        int result = 0;
        int left = 0;
        for (int i = k; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        while (left <= cardPoints.length - k) {
            if (left > 0) {
                sum += cardPoints[left - 1];
                if (left + k - 1 < cardPoints.length) {
                    sum -= cardPoints[left + k - 1];
                }
            }
            result = Math.max(sum, result);
            left++;
        }
        return result;
    }

}
