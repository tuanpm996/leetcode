package problems.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem322 {
    public static void main(String[] args) {
        int[] coins = {
                1, 2, 5
        };
        int amount = 11;
        int i = new Problem322().coinChange(coins, amount);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(amount);
        visited.add(amount);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int currSum = queue.poll();
                if (currSum == 0) return depth;
                if (currSum < 0) continue;
                for (int coin : coins) {
                    int target = currSum - coin;
                    if (target >= 0 && !visited.contains(target)) {
                        queue.offer(target);
                        visited.add(target);
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}
