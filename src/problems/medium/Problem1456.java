package problems.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem1456 {
    public static void main(String[] args) {
        int i = new Problem1456().maxVowels("", 3945);
        System.out.println(i);
    }

    public int maxVowels(String s, int k) {
        int left = 0;
        int right = k - 1;
        int result = 0;
        int currentVowel = 0;
        LinkedList<Character> temp = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (isVowels(s.charAt(i))) {
                currentVowel++;
            }
            temp.add(s.charAt(i));
        }
        while (left <= s.length() - k) {
            if (left > 0) {
                if (isVowels(temp.getFirst())) {
                    currentVowel--;
                }
                temp.removeFirst();
                if (isVowels(s.charAt(right))) {
                    currentVowel++;
                }
                temp.add(s.charAt(right));
            }
            result = Math.max(currentVowel, result);
            left++;
            right++;
        }
        return result;
    }

    private boolean isVowels(char aChar) {
        if (aChar == 'a') {
            return true;
        }
        if (aChar == 'e') {
            return true;
        }
        if (aChar == 'i') {
            return true;
        }
        if (aChar == 'o') {
            return true;
        }
        if (aChar == 'u') {
            return true;
        }
        return false;
    }
}
