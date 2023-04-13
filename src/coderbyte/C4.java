package coderbyte;

import java.util.LinkedList;
import java.util.Queue;

public class C4 {

    public static void main(String[] args) {
        // keep this function call here
        int i = CoinDeterminer(25);
        System.out.println(i);
    }

    public static int CoinDeterminer(int num) {
        // code goes here
        int[] seeds = {1, 5, 7, 9, 11};
        Queue<Info> queue = new LinkedList<>();
        for (int seed : seeds) {
            queue.add(new Info(seed, 0));
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Info poll = queue.poll();
                if (poll.sum > num) {
                    continue;
                }
                if (poll.sum == num) {
                    return poll.depth + 1;
                } else {
                    for (int seed : seeds) {
                        queue.add(new Info(poll.sum + seed, poll.depth + 1));
                    }
                }
            }
        }
        return num;
    }


    public static class Info {
        int sum;
        int depth;

        public Info(int sum, int depth) {
            this.sum = sum;
            this.depth = depth;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "sum=" + sum +
                    ", depth=" + depth +
                    '}';
        }
    }

}
