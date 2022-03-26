package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1992 {
    public static void main(String[] args) {
        int[][] ints = {
//                new int[]{1, 0, 0},
//                new int[]{0, 1, 1},
//                new int[]{0, 1, 1},
                new int[]{1, 1},
                new int[]{0, 0}
        };
        int[][] farmland = new Problem1992().findFarmland(ints);
        System.out.println(Arrays.deepToString(farmland));
    }

    public int[][] findFarmland(int[][] lands) {
        int rowNum = lands.length;
        int colNum = lands[0].length;
        List<int[]> results = new ArrayList<>(1000);
        boolean[][] visited = new boolean[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < lands[i].length; j++) {
                int cur = lands[i][j];
                if (cur == 1 && !visited[i][j]) {
                    int[] result = new int[4];
                    visited[i][j] = true;
                    result[0] = i;
                    result[1] = j;
                    int rowIdx = i + 1;
                    while (rowIdx < rowNum && lands[rowIdx][j] == 1) {
                        visited[rowIdx][j] = true;
                        rowIdx++;
                    }
                    result[2] = rowIdx - 1;
                    int colIdx = j + 1;
                    while (colIdx < colNum && lands[i][colIdx] == 1) {
                        visited[i][colIdx] = true;
                        colIdx++;
                    }
                    result[3] = colIdx - 1;
                    for (int k = i + 1; k <= rowIdx - 1; k++) {
                        for (int l = j + 1; l <= colIdx - 1; l++) {
                            visited[k][l] = true;
                        }
                    }
                    results.add(result);
                }
            }
        }
        int[][] array = new int[results.size()][4];
        return results.toArray(array);
    }
}
