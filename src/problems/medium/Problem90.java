package problems.medium;

import java.util.*;

public class Problem90 {

    public static void main(String[] args) {
//        [[],[1],[1,1],[1,1,2],[1,1,2,2],[2],[1,2],[2,2],[1,2,2],[2],[2,2]]
//        [[],[1],[1,1],[1,1,2],[1,1,2,2],[2],[1,2],[2,2],[1,2,2],]

        List<List<Integer>> lists = new Problem90().subsetsWithDup(new int[]{1, 1, 2, 2});
        System.out.println(lists);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> num2Count = new HashMap<>();
        for (int num : nums) {
            if (!num2Count.containsKey(num)) {
                num2Count.put(num, 1);
            } else {
                num2Count.put(num, num2Count.get(num) + 1);
            }
        }
        List<Integer> keys = new ArrayList<>(num2Count.keySet());
        List<List<Integer>> results = getResults(num2Count, keys, 0);
        results.add(Collections.emptyList());
        return results;
    }

    private List<List<Integer>> getResults(Map<Integer, Integer> num2Count, List<Integer> keys, int i) {
        List<List<Integer>> results = new ArrayList<>();
        Integer key = keys.get(i);
        Integer occurrenceCount = num2Count.get(key);
        List<List<Integer>> subResults = null;
        if (i + 1 < keys.size()) {
            subResults = getResults(num2Count, keys, i + 1);
        }
        if (subResults != null) {
            for (List<Integer> subResult : subResults) {
                results.add(new ArrayList<>(subResult));
            }
        }
        for (int j = 0; j < occurrenceCount; j++) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k <= j; k++) {
                list.add(key);
            }
            if (subResults != null) {
                for (List<Integer> subResult : subResults) {
                    List<Integer> integers = new ArrayList<>(list);
                    integers.addAll(subResult);
                    results.add(integers);
                }

            }
            results.add(list);
        }
        return results;
    }


}
