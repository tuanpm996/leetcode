package problems.medium;

public class Problem221 {
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                new char[]{'1', '0', '1', '0'},
                new char[]{'1', '0', '1', '1'},
                new char[]{'1', '0', '1', '1'},
                new char[]{'1', '1', '1', '1'},
        };
        int i = new Problem221().maximalSquare(chars);
        System.out.println(i);
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i - 1 < 0 || j - 1 < 0) {
                    dp[i][j] = Character.getNumericValue(matrix[i][j]);
                    max = Math.max(max, dp[i][j]);
                    continue;
                }
                if (dp[i][j - 1] == 0 || dp[i - 1][j] == 0 || dp[i - 1][j - 1] == 0) {
                    dp[i][j] = Character.getNumericValue(matrix[i][j]);
                } else if (Character.getNumericValue(matrix[i][j]) != 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

}
