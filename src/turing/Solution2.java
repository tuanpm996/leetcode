package turing;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        boolean valid = isValid("()[]{}");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        List<Character> open = Arrays.asList('(', '{', '[');
        List<Character> close = Arrays.asList(')', '}', ']');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                if (open.contains(c)) {
                    stack.add(c);
                } else {
                    Character pop = stack.pop();
                    if (open.indexOf(pop) != close.indexOf(c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
