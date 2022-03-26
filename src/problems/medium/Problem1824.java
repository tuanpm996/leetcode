package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1824 {

    public static void main(String[] args) {
        int i = new Problem1824().minSideJumps(new int[]{0, 1, 2, 3, 0});
        System.out.println(i);

    }

    public int minSideJumps(int[] obstacles) {
        int length = obstacles.length;
        int[][] ints = new int[3][length +1];
        for (int i = 0; i < obstacles.length; i++) {
            if (obstacles[i] > 0) {
                ints[obstacles[i] - 1][i] = -1;
            }
        }

        for (int i = 0; i < obstacles.length; i++) {
            int[] anInt = ints[i];
            List<Integer> able = new ArrayList<>();
            List<Integer> notAble = new ArrayList<>();
            for (int j = 0; j < anInt.length; j++) {
                if (ints[i - 1][j] == -1) {
                    notAble.add(i);
                } else {
                    able.add(i);
                }
            }
            for (int i1 = 0; i1 < able.size(); i1++) {
                if (anInt[i1] != -1) {
                    anInt[i1] = ints[i - 1][i1];
                }
            }
            for (int i1 = 0; i1 < notAble.size(); i1++) {
                if (anInt[i1] != -1) {
                    if (i1 == 0) {
                        anInt[i1] = anInt[1] == -1 ? anInt[2] + 1 : anInt[1];
                    }
                    if (i1 == 2) {
                        anInt[i1] = anInt[1] == -1 ? anInt[0] + 1 : anInt[1];
                    }
                    if (i1 == 1) {
                        anInt[i1] = anInt[0] == -1 ? anInt[2] : anInt[0];
                    }
                }
            }
        }
        return ints[ints.length - 1][0];
    }
}
