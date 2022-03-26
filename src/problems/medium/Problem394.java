package problems.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem394 {

    public static void main(String[] args) {
        String s = new Problem394().decodeString("13[a2[c]]");
        System.out.println(s);
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(c);
            } else {
                List<Character> characters = new ArrayList<>();
                do {
                    Character pop = stack.pop();
                    characters.add(pop);
                } while (stack.peek() != '[');
                stack.pop();
                StringBuilder stringBuilder = new StringBuilder();
                while (stack.size() > 0 && Character.isDigit(stack.peek())) {
                    Character pop = stack.pop();
                    stringBuilder.append(pop);
                }
                int time = Integer.parseInt(stringBuilder.reverse().toString());
                for (int j = 0; j < time; j++) {
                    for (int k = characters.size() - 1; k >= 0; k--) {
                        stack.push(characters.get(k));
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (stack.size() > 0) {
            stringBuilder.append(stack.pop());
        }
        StringBuilder reverse = stringBuilder.reverse();
        return reverse.toString();
    }
}
