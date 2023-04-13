package turing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5 {
    public static void main(String[] args) {
        List<Integer> res = new Solution5().rotate(Arrays.asList(-1, -100, 3, 99), 2);
        System.out.println(res);

    }

    public List<Integer> rotate(List<Integer> list, int pos) {
        List<Integer> res = new ArrayList<>();
        int newPos = list.size() - 1 - pos;
        for (int i = newPos + 1; i < list.size(); i++) {
            res.add(list.get(i));
        }
        for (int i = 0; i < newPos + 1; i++) {
            res.add(list.get(i));
        }
        return res;
    }
}
