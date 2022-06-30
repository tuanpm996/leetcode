package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem397 {
    public static void main(String[] args) {
        int i = new Problem397().integerReplacement(2147483647);
        System.out.println(i);
    }

    public int integerReplacement(int n) {
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, n));
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            if (data.number == 1) {
                return data.step;
            }
            if (data.number % 2 == 0) {
                Data data1 = new Data(data.step + 1, data.number / 2);
                queue.add(data1);
            } else {
                Data data1 = new Data(data.step + 1, data.number - 1);
                queue.add(data1);
                Data data2 = new Data(data.step + 1, data.number + 1);
                queue.add(data2);
            }
        }
        return 1;
    }

    private static class Data {
        int step;
        long number;

        public Data(int step, long number) {
            this.step = step;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "step=" + step +
                    ", number=" + number +
                    '}';
        }
    }
}
