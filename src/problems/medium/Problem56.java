package problems.medium;

import java.util.*;

public class Problem56 {
    public static void main(String[] args) {
//         [[1,3],[2,6],[8,10],[15,18]]
        int[][] ints = {
                new int[]{1, 4},
                new int[]{4, 5},
        };
        int[][] merge = new Problem56().merge(ints);
        System.out.println(Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> ints = new LinkedList<>();
        Collections.addAll(ints, intervals);
        ints.sort(Comparator.comparing(o -> o[0]));
        for (int i = 0; i < ints.size() - 1; i++) {
            while (i + 1 < ints.size() && ints.get(i)[1] >= ints.get(i + 1)[0]) {
                int[] curr = ints.get(i);
                int[] next = ints.get(i + 1);
                curr[1] = Math.max(curr[1], next[1]);
                ints.remove(i + 1);
            }
        }
        return ints.toArray(new int[][]{});
    }
}
