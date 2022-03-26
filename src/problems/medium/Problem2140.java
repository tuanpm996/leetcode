package problems.medium;

public class Problem2140 {

    public static void main(String[] args) {
//        [[21,5],[92,3],[74,2],[39,4],[58,2],[5,5],[49,4],[65,3]]
        int[][] ints = {
                new int[]{21, 5},
                new int[]{92, 3},
                new int[]{74, 2},
                new int[]{39, 4},
                new int[]{58, 2},
                new int[]{5, 5},
                new int[]{49, 4},
                new int[]{65, 3},
        };
        long l = new Problem2140().mostPoints(ints);
        System.out.println(l);
    }

    public long mostPoints(int[][] questions) {
        int length = questions.length;
        long[] dp = new long[length];
        for (int i = length - 1; i >= 0; i--) {
            int[] question = questions[i];
            if (i < length - 1) {
                if (i + question[1] + 1 < length) {
                    dp[i] = Math.max(question[0] + dp[i + question[1] + 1], dp[i + 1]);
                } else {
                    dp[i] = Math.max(question[0], dp[i + 1]);
                }
            } else {
                dp[i] = question[0];
            }
        }
        return dp[0];
    }
}
