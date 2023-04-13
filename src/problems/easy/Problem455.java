package problems.easy;

import java.util.Arrays;

public class Problem455 {

    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {5, 6, 7, 8};
        int contentChildren = new Problem455().findContentChildren(g, s);
        System.out.println(contentChildren);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gPtr = 0;
        int sPtr = 0;
        int res = 0;
        while (sPtr < s.length && gPtr < g.length) {
            if (g[gPtr] <= s[sPtr]) {
                res++;
                gPtr++;
            }
            sPtr++;
        }
        return res;
    }

}
