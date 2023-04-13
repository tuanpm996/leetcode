package problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem442 {

    public static void main(String[] args) {

    }

    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                res.add(num);
            } else {
                seen.add(num);
            }
        }
        return res;
    }
}
