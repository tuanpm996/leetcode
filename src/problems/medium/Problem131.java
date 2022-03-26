package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {
    public static void main(String[] args) {
        String a = "bb";
        List<List<String>> partition = new Problem131().partition(a);
        System.out.println(partition);
    }

    public List<List<String>> partition(String s) {
        if (s.length() <= 1) {
            return new ArrayList<>() {{
                add(new ArrayList<>() {{
                    add(s);
                }});
            }};
        }
        List<List<String>> results = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (isPalindrome(left)) {
                List<List<String>> partition = partition(right);
                for (List<String> strings : partition) {
                    strings.add(0, left);
                }
                results.addAll(partition);
            }
        }
        if (isPalindrome(s)) {
            results.add(new ArrayList<>() {{
                add(s);
            }});
        }
        return results;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
