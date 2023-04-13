package problems.easy;

import problems.medium.Problem34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem2089 {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ints = new Problem34().searchRange(nums, target);
        if (ints[0] == -1) {
            return Collections.emptyList();
        }
        List<Integer> results = new ArrayList<>();
        for (int i = ints[0]; i <= ints[1]; i++) {
            results.add(i);
        }
        return results;
    }
}
