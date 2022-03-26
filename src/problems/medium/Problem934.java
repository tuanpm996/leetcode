package problems.medium;

import java.util.*;

public class Problem934 {
    public static void main(String[] args) {
        int[][] ints = {
                new int[]{0, 1, 0},
                new int[]{0, 0, 0},
                new int[]{0, 0, 1},
        };
        int i = new Problem934().shortestBridge(ints);
        System.out.println(i);
    }

    public int shortestBridge(int[][] grid) {
        List<int[]> firstIsland = new ArrayList<>();
        loop:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    findIsland(grid, i, j, firstIsland);
                    break loop;
                }
            }
        }
        return findPathToTheOther(grid, firstIsland);
    }

    private int findPathToTheOther(int[][] grid, List<int[]> firstIsland) {
        HashSet<List<Integer>> firstIslandSet = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int[] ints : firstIsland) {
            queue.add(new int[]{ints[0], ints[1]});
            firstIslandSet.add(Arrays.asList(ints[0], ints[1]));
        }
        int[] iList = {-1, 0, 1, 0};
        int[] jList = {0, -1, 0, 1};
        int depth = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] ele = queue.poll();
                if (!firstIslandSet.contains(Arrays.asList(ele[0], ele[1])) && grid[ele[0]][ele[1]] == 1) {
                    return depth;
                }
                for (int k = 0; k < iList.length; k++) {
                    int curI = ele[0] + iList[k];
                    int curJ = ele[1] + jList[k];
                    if (curI >= 0 && curI < grid.length && curJ >= 0 && curJ < grid[0].length && !firstIslandSet.contains(Arrays.asList(curI, curJ)) && !visited[curI][curJ]) {
                        queue.add(new int[]{curI, curJ});
                        visited[curI][curJ] = true;
                    }
                }
            }
            depth++;
        }

        return 1;
    }

    private void findIsland(int[][] grid, int i, int j, List<int[]> firstIsland) {
        int[] iList = {-1, 0, 1, 0};
        int[] jList = {0, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] ele = queue.poll();
                firstIsland.add(new int[]{ele[0], ele[1]});
                for (int k = 0; k < iList.length; k++) {
                    int curI = ele[0] + iList[k];
                    int curJ = ele[1] + jList[k];
                    if (curI >= 0 && curI < grid.length && curJ >= 0 && curJ < grid[0].length && grid[curI][curJ] == 1 && !visited[curI][curJ]) {
                        visited[curI][curJ] = true;
                        queue.add(new int[]{curI, curJ});
                    }
                }
            }
        }
    }
}
