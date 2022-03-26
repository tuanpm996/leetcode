package problems.medium;

public class Problem64 {

    public static void main(String[] args) {
        int[][] ints = {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
        };
        int result = new Problem64().minPathSum(ints);
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i != 0 || j != 0) {
                    int add;
                    if (j == 0) {
                        add = grid[i - 1][j];
                    } else if (i == 0) {
                        add = grid[i][j - 1];
                    } else {
                        add = Math.min(grid[i - 1][j], grid[i][j - 1]);
                    }
                    grid[i][j] = grid[i][j] + add;
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
