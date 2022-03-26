package problems.medium;

import java.util.*;

public class Problem120 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>() {{
            add(Collections.singletonList(-1));
            add(Arrays.asList(2, 3));
            add(Arrays.asList(1, -1, -3));
        }};
        int i = new Problem120().minimumTotal(lists);
        System.out.println(i);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> cache = new HashMap<>();
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        List<Integer> integers = triangle.get(0);
        return integers.get(0) + getSum(triangle, 1, 0, cache);
    }

    private Integer getSum(List<List<Integer>> triangle, int curRow, int curIndex, Map<String, Integer> cache) {
        String key = String.format("%d|%d", curRow, curIndex);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        List<Integer> integers = triangle.get(curRow);
        int minVal = Integer.MAX_VALUE;
        if (curRow == triangle.size() - 1) {
            int min = Math.min(integers.get(curIndex), integers.get(curIndex + 1));
            cache.put(key, min);
            return min;
        }
        for (int i = curIndex; i <= curIndex + 1; i++) {
            minVal = Math.min(integers.get(i) + getSum(triangle, curRow + 1, i, cache), minVal);
        }
        cache.put(key, minVal);
        return minVal;
    }
}
