package problems.medium;

import java.util.*;

public class Problem752 {
    public static void main(String[] args) {
        int res = new Problem752().openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(res);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> seen = new HashSet<>();
        Queue<Status> queue = new LinkedList<>();
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (!dead.contains("0000")) {
            Status initStatus = new Status("0000", 0);
            queue.add(initStatus);
        }
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Status curStatus = queue.poll();
                if (seen.contains(curStatus.wheel)) {
                    continue;
                }
                seen.add(curStatus.wheel);
                if (target.equals(curStatus.wheel)) {
                    res = Math.min(res, curStatus.step);
                }
                List<Status> nextStatuses = getNextStatuses(curStatus, seen, dead);
                queue.addAll(nextStatuses);
            }
        }
        return res < Integer.MAX_VALUE ? res : -1;

    }

    private List<Status> getNextStatuses(Status curStatus, Set<String> seen, Set<String> dead) {
        List<Status> statuses = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt("" + curStatus.wheel.charAt(i));
            int[] newNums = new int[2];
            if (num == 0) {
                newNums[0] = 9;
                newNums[1] = 1;
            } else if (num == 9) {
                newNums[0] = 8;
            } else {
                newNums[0] = num - 1;
                newNums[1] = num + 1;
            }
            StringBuilder sb1 = new StringBuilder(curStatus.wheel);
            sb1.setCharAt(i, String.valueOf(newNums[0]).charAt(0));

            StringBuilder sb2 = new StringBuilder(curStatus.wheel);
            sb2.setCharAt(i, String.valueOf(newNums[1]).charAt(0));

            if (!seen.contains(sb1.toString()) && !dead.contains(sb1.toString())) {
                statuses.add(new Status(sb1.toString(), curStatus.step + 1));
            }
            if (!seen.contains(sb2.toString()) && !dead.contains(sb2.toString())) {
                statuses.add(new Status(sb2.toString(), curStatus.step + 1));
            }
        }
        return statuses;
    }

    private static class Status {
        String wheel;
        int step;

        public Status(String wheel, int step) {
            this.wheel = wheel;
            this.step = step;
        }
    }

}
