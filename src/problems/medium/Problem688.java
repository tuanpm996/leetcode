package problems.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Problem688 {

    public static void main(String[] args) {
        double v = new Problem688().knightProbability(1, 0, 0, 0);
        System.out.println(v);
    }

    private int[] xList = new int[]{-2, -2, -1, 1, 2, 2, -1, 1};
    private int[] yList = new int[]{-1, 1, -2, -2, -1, 1, 2, 2};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        for (double[][] doubles : dp) {
            for (double[] aDouble : doubles) {
                Arrays.fill(aDouble, -1);
            }
        }
        return find(n, k, row, column, dp);
    }

    private double find(int n, int k, int row, int column, double[][][] dp) {
        if (k == 0) {
            boolean b = row >= 0 && row < n && column >= 0 && column < n;

            if (b) {
                dp[row][column][k] = 1;
            }
            return b ? 1 : 0;
        }
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (dp[row][column][k] != -1) {
            return dp[row][column][k];
        }
        double sum = 0;
        for (int j = 0; j < xList.length; j++) {
            sum += 0.125 * find(n, k - 1, row + xList[j], column + yList[j], dp);
        }
        dp[row][column][k] = sum;
        return sum;
    }

}
