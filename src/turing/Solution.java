package turing;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        String[] data = {"5", "2", "C", "D", "+"};
        int i = calPoints(data);
        System.out.println(i);
    }

    public static int calPoints(String[] ops) {
        List<Integer> results = new ArrayList<>();
        for (String op : ops) {
            switch (op) {
                case "C":
                    results.remove(results.size() - 1);
                    break;
                case "D":
                    results.add(results.get(results.size() - 1) * 2);
                    break;
                case "+":
                    results.add(results.get(results.size() - 1) + results.get(results.size() - 2));
                    break;
                default:
                    int number = Integer.parseInt(op);
                    results.add(number);
                    break;
            }
        }
        return results.stream().
                mapToInt(t -> t)
                .sum();
    }
}
