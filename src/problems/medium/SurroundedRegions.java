package problems.medium;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] ints = {
                new char[]{'X', 'X', 'X', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'O', 'O', 'X'},
                new char[]{'X', 'O', 'X', 'X'},
        };
        new SurroundedRegions().solve(ints);
    }

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isOAtBorder(board, i, j) && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        int[] iAxis = {-1, 0, 1, 0};
        int[] jAxis = {0, -1, 0, 1};
        Queue<Info> queue = new LinkedBlockingQueue<>();
        queue.add(new Info(i, j));
        while (!queue.isEmpty()) {
            Info info = queue.poll();
            board[info.i][info.j] = '1';
            for (int k = 0; k < iAxis.length; k++) {
                int curI = info.i + iAxis[k];
                int curJ = info.j + jAxis[k];
                if (curI >= 0 && curJ >= 0 && curI < board.length && curJ < board[0].length && board[curI][curJ] == 'O') {
                    board[curI][curJ] = '1';
                    queue.add(new Info(curI, curJ));
                }
            }
        }
    }

    private boolean isOAtBorder(char[][] board, int i, int j) {
        return i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1;
    }

    private static class Info {
        int i;
        int j;

        public Info(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object obj) {
            Info obj1 = (Info) obj;
            return obj1.j == j && obj1.i == i;
        }
    }
}
