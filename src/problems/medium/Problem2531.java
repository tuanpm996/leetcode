package problems.medium;

public class Problem2531 {

    public static void main(String[] args) {
//        boolean itPossible = new Problem2531().isItPossible();
//        System.out.println(itPossible);
        System.out.println('z' - 'a');
        System.out.println('a' - 'z');
        for (int i = 0; i < "acfgbd".length(); i++) {
            System.out.println("acfgbd".charAt(i) - 'a');
        }

    }

    public boolean isItPossible(String word1, String word2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        int countDistinct1 = 0;
        int countDistinct2 = 0;
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            if (map1[c - 'a'] == 0) {
                countDistinct1++;
            }
            map1[c - 'a']++;
        }
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            if (map2[c - 'a'] == 0) {
                countDistinct2++;
            }
            map2[c - 'a']++;
        }
        for (int i = 0; i < map1.length; i++) {
            for (int j = 0; j < map2.length; j++) {
                if (map1[i] == 0 || map2[j] == 0) {
                    continue;
                }
                int newDistinct1 = countDistinct1;
                int newDistinct2 = countDistinct2;
                if (j != i) {
                    if (map1[j] == 0) {
                        newDistinct1++;
                    }
                    if (map2[j] == 1) {
                        newDistinct2--;
                    }
                    if (map2[i] == 0) {
                        newDistinct2++;
                    }
                    if (map1[i] == 1) {
                        newDistinct1--;
                    }
                }
                if (newDistinct1 == newDistinct2) {
                    return true;
                }
            }
        }
        return false;
    }
}
