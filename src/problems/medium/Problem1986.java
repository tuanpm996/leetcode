package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1986 {
    public static void main(String[] args) {
        int[] ints = {2, 3, 3, 4, 4, 4, 5, 6, 7, 10};
        int i = new Problem1986().minSessions(ints, 12);
        System.out.println(i);
    }

    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        List<Integer> taskTimes = new ArrayList<>();
        for (int task : tasks) {
            taskTimes.add(task);
        }
        int count = 0;
        while (taskTimes.size() != 0) {
            int curr = sessionTime;
            List<Integer> remove = new ArrayList<>();
            for (int i = taskTimes.size() - 1; i >= 0; i--) {
                if (curr - taskTimes.get(i) >= 0) {
                    curr -= taskTimes.get(i);
                    remove.add(i);
                }
            }
            for (Integer integer : remove) {
                taskTimes.remove((int) integer);
            }
            count++;
        }
        return count;
    }
}
