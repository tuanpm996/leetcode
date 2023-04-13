package problems.medium;

public class Problem2055 {
    public static void main(String[] args) {
        String s = "";
        int[][] ints = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};

        new Problem2055().platesBetweenCandles("***|**|*****|**||**|*", ints);
    }


    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] result = new int[queries.length];
        int[][] count = new int[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                count[i][0] = count[i - 1][0];
                count[i][1] = count[i - 1][1];
            }
            char c = s.charAt(i);
            if (c == '|') {
                count[i][0]++;
            } else {
                count[i][1]++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = findResult(s, query, count);
        }
        return result;
    }

    private int findResult(String s, int[] query, int[][] count) {
        int leftCandle = -1;
        if (s.charAt(query[0]) == '|') {
            leftCandle = query[0];
        } else {
            int left = query[0] + 1;
            int right = s.length() - 1;
            loop:
            while (left < right) {
                int mid = (left + right) / 2;
                if (count[mid][0] == count[query[0]][0] + 1) {
                    if (left == mid) {
                        leftCandle = left;
                        break loop;
                    }
                    right = mid;
                } else if (count[mid][0] > count[query[0]][0] + 1) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (leftCandle == -1 && count[right][0] == count[query[0]][0] + 1) {
                leftCandle = right;
            }
        }
        if (leftCandle == -1) {
            return 0;
        }
        int rightCandle = -1;
        if (s.charAt(query[1]) == '|') {
            rightCandle = query[1];
        } else {
            int left = 0;
            int right = query[1] - 1;
            loop2:
            while (left < right) {
                int mid = (left + right) / 2;
                if (count[mid][0] == count[query[1]][0] - 1) {
                    if (left == mid) {
                        rightCandle = right;
                        break loop2;
                    }
                    left = mid;
                } else if (count[mid][0] < count[query[1]][0] - 1) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (rightCandle == -1 && count[left][0] == count[query[1]][0] - 1) {
                rightCandle = left;
            }
        }
        if (rightCandle == -1) {
            return 0;
        }
        return Math.max(count[rightCandle][1] - count[leftCandle][1], 0);
    }
}