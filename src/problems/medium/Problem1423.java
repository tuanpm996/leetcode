package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1423 {

    public static void main(String[] args) {
        int i = new Problem1423().maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3);
        System.out.println(i);
    }

    public int maxScore(int[] cardPoints, int k) {
        if (k == 1) {
            return Math.max(cardPoints[0], cardPoints[cardPoints.length - 1]);
        }
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, null, null, 0));
        int max = 0;
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            if (data.step == k - 1) {
                max = Math.max(data.sum, max);
            } else {
                if (data.lastLeft == null) {
                    queue.add(new Data(0, 0, data.lastRight, cardPoints[0]));
                }
                if (data.lastRight == null) {
                    queue.add(new Data(0, data.lastLeft, cardPoints.length - 1, cardPoints[cardPoints.length - 1]));
                }
                if (data.lastRight != null && data.lastLeft != null) {
                    if (data.lastLeft < data.lastRight) {
                        queue.add(new Data(data.step + 1, data.lastLeft + 1, data.lastRight, data.sum + cardPoints[data.lastLeft + 1]));
                        queue.add(new Data(data.step + 1, data.lastLeft, data.lastRight - 1, data.sum + cardPoints[data.lastRight - 1]));
                    }
                }
            }
        }
        return max;
    }

    private static class Data {
        int step;
        Integer lastLeft;

        Integer lastRight;
        int sum;


        public Data(int step, Integer lastLeft, Integer lastRight, int sum) {
            this.step = step;
            this.lastLeft = lastLeft;
            this.lastRight = lastRight;
            this.sum = sum;
        }
    }
}
