package problems.medium;

import java.util.*;

public class Problem1424 {
    public static void main(String[] args) {
        int[] diagonalOrder = new Problem1424().findDiagonalOrder(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9)));
        System.out.println(Arrays.toString(diagonalOrder));
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> results = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        Set<String> mem = new HashSet<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] pos = queue.poll();
                int i = pos[0];
                int j = pos[1];
                if (i + 1 < nums.size()) {
                    List<Integer> list = nums.get(i + 1);
                    if (j < list.size()) {
                        if (!mem.contains((i + 1) + "|" + j)) {
                            queue.add(new int[]{i + 1, j});
                            mem.add((i + 1) + "|" + j);
                        }
                    }
                }
                List<Integer> list = nums.get(i);
                if (j + 1 < list.size()) {
                    if (!mem.contains(i + "|" + (j + 1))) {
                        queue.add(new int[]{i, j + 1});
                        mem.add(i + "|" + (j + 1));
                    }
                }
                results.add(nums.get(i).get(j));
                size--;
            }
        }

        return results.stream().mapToInt(t -> t).toArray();

    }
}
