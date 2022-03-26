package problems.medium;

import java.util.*;

public class Problem1654 {
    public static void main(String[] args) {
        int[] ints = {162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98};
        int i = new Problem1654().minimumJumps(ints, 29, 98, 80);
        System.out.println(i);
    }

    private Map<String/*idx + direction*/, Integer> cache;

    public int minimumJumps2(int[] forbidden, int a, int b, int x) {
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0, 0, 0});//step, current index, direction(0 is back, 1 is forward)
        Set<Integer> forbit = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int maxLimit = 2000 + 2 * b;
        for (int num : forbidden) {
            forbit.add(num);
            maxLimit = Math.max(maxLimit, num + 2 * b);
        }
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int step = node[0];
            int idx = node[1];
            int dir = node[2];
            System.out.println(idx);
            if (idx == x) return step;
            //try jump forward
            if (idx + a < maxLimit && !forbit.contains(idx + a) && !visited.contains(idx + a + "," + 0)) {
                visited.add(idx + a + "," + 0);
                pq.offer(new int[]{step + 1, idx + a, 0});
            }
            //try jump back
            if (idx - b >= 0 && !forbit.contains(idx - b) && !visited.contains(idx - b + "," + 1) && dir != 1) {
                visited.add(idx - b + "," + 1);
                pq.offer(new int[]{step + 1, idx - b, 1});
            }
        }
        return -1;
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int furthest = 2000 + 2 * b;
        Queue<Result> queue = new LinkedList<>();
        Set<Result> visited = new HashSet<>();
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int i : forbidden) {
            forbiddenSet.add(i);
            furthest = Math.max(furthest, i + 2 * b);
        }
        queue.add(new Result(0, false));
        visited.add(new Result(0, false));
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Result ele = queue.poll();
                if (ele.pos == x) {
                    return depth;
                }
                List<Result> nextStates = getNextStates(ele, forbiddenSet, a, b, furthest, visited);
                queue.addAll(nextStates);
            }
            depth++;
        }
        return -1;
    }

    private List<Result> getNextStates(Result result, Set<Integer> forbidden, int a, int b, int furthest, Set<Result> visited) {
        List<Result> results = new ArrayList<>();
        if (!forbidden.contains(result.pos + a) && (result.pos + a) <= furthest && !visited.contains(new Result(result.pos + a, false))) {
            results.add(new Result(result.pos + a, false));
            visited.add(new Result(result.pos + a, false));
        }
        if ((result.pos - b) >= 0 && !forbidden.contains(result.pos - b) && !result.isBackward && !visited.contains(new Result(result.pos - b, true))) {
            results.add(new Result(result.pos - b, true));
            visited.add(new Result(result.pos - b, true));
        }
        return results;
    }

    private static class Result {
        int pos;
        boolean isBackward;

        public Result(int pos, boolean isBackward) {
            this.pos = pos;
            this.isBackward = isBackward;
        }

        @Override
        public boolean equals(Object obj) {
            Result obj1 = (Result) obj;
            return obj1.isBackward == isBackward && pos == obj1.pos;
        }

        @Override
        public int hashCode() {
            return String.format("%d|%b", pos, isBackward).hashCode();
        }

        @Override
        public String toString() {
            return String.format("%d|%b", pos, isBackward);
        }
    }
}
