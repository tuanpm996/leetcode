package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem46 {

    public static void main(String[] args) {
        List<List<Integer>> permute = new Problem46().permute(new int[]{1, 1, 2});
        System.out.println(Arrays.toString(permute.toArray()));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, Collections.emptyList(), nums);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> currentList, int[] nums) {
        for (int num : nums) {
            if (currentList.contains(num)) {
                continue;
            }
            List<Integer> cloned = new ArrayList<>(currentList);
            cloned.add(num);
            if (cloned.size() == nums.length) {
                results.add(cloned);
            } else {
                backtrack(results, cloned, nums);
            }
        }
    }
}
