package problems.medium;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem128 {

    public static void main(String[] args) {
        int i = new Problem128().longestConsecutive(new int[]{});
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> integers = IntStream.of(nums)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        int result = 0;

        for (Integer integer : integers) {
            int curr = integer;
            if (integers.contains(curr - 1)) {
                continue;
            }
            int temp = 0;
            while (integers.contains(curr)) {
                temp += 1;
                curr += 1;
            }
            result = Math.max(result, temp);
        }
        return result;
    }
}
