package problems.medium;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Problem695 {
    public static void main(String[] args) {
        int[][] ints = {
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        };
        int i = new Problem695().maxAreaOfIsland(ints);
        System.out.println(i);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int[] iList = {0, -1, 0, 1};
        int[] jList = {-1, 0, 1, 0};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int val = grid[i][j];
                if (val == 1 && !visited[i][j]) {
                    int count = 0;
                    Queue<int[]> queue = new ArrayBlockingQueue<>(100);
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        for (int i1 = 0; i1 < iList.length; i1++) {
                            int curI = poll[0] + iList[i1];
                            int curJ = poll[1] + jList[i1];
                            if (curI >= 0 && curI < grid.length
                                    && curJ >= 0 && curJ < grid[0].length &&
                                    !visited[curI][curJ] && grid[curI][curJ] == 1) {
                                queue.add(new int[]{curI, curJ});
                                visited[curI][curJ] = true;
                            }
                        }
                        count++;
                    }
                    maxArea = Math.max(maxArea, count);
                }
            }
        }
        return maxArea;
    }

}
