package problems.medium;

import java.util.TreeMap;

public class Problem729 {

    public static void main(String[] args) {

    }

    private static class MyCalendar {

        TreeMap<Integer, Integer> calendar;

        MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer prev = calendar.floorKey(start);
            Integer next = calendar.ceilingKey(start);
            if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
                calendar.put(start, end);
                return true;
            }
            return false;
        }
    }


}
