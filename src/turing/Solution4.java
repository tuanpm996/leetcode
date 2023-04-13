package turing;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution4 {
    public static void main(String[] args) {
        boolean valid = new Solution4().isValid("[{}]");
        System.out.println(valid);
    }

    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        List<Character> opens = Arrays.asList('(', '[', '{');
        List<Character> closes = Arrays.asList(')', ']', '}');
        for (char aChar : chars) {
            if (opens.contains(aChar)) {
                stack.push(aChar);
            } else if (closes.contains(aChar)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (opens.indexOf(pop) != closes.indexOf(aChar)) {
                    return false;
                }
            }
        }
        return true;
    }
}
