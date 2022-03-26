package problems.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1091 {
    public static void main(String[] args) {
//        [0,0,0],[1,1,0],[1,1,0]
        int[][] ints = {
                new int[]{0, 1},
                new int[]{1, 0},
        };
        int i = new Problem1091().shortestPathBinaryMatrix(ints);
        System.out.println(i);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0, 0));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] iList = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] jList = {-1, 0, 1, -1, 1, -1, 0, 1};
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                List<Integer> ele = queue.poll();
                if (ele.get(0) == grid.length - 1 && ele.get(1) == grid[0].length - 1) {
                    return length;
                }
                for (int i = 0; i < iList.length; i++) {
                    int curI = ele.get(0) + iList[i];
                    int curJ = ele.get(1) + jList[i];
                    if (curI >= 0 && curI < grid.length && curJ >= 0 && curJ < grid[0].length && !visited[curI][curJ] && grid[curI][curJ] == 0) {
                        queue.add(Arrays.asList(curI, curJ));
                        visited[curI][curJ] = true;
                    }
                }
            }
            length++;
        }
        return -1;
    }
}
