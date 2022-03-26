package problems.medium;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class Problem279 {
    public static void main(String[] args) {
        int i = new Problem279().numSquares(12);
        System.out.println(i);
    }

    public int numSquares(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        int sqrt = (int) Math.sqrt(n);
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(n);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer currNum = queue.poll();
                if (currNum == 0) {
                    return depth;
                }
                if (currNum < 0) {
                    continue;
                }
                for (int i = sqrt; i >= 1; i--) {
                    int newCurrNum = currNum - i * i;
                    if (newCurrNum >= 0 && !visited.contains(newCurrNum)) {
                        queue.add(newCurrNum);
                        visited.add(newCurrNum);
                    }
                }
            }
            depth++;
        }
        return 0;
    }
}
