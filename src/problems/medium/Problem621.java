package problems.medium;

public class Problem621 {

    public static void main(String[] args) {
        int i = new Problem621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        System.out.println(i);

    }

    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }
        return 0;
    }
}
