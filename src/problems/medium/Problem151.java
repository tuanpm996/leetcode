package problems.medium;

public class Problem151 {

    public static void main(String[] args) {
        String the_sky_is_blue = new Problem151().reverseWords("  hello world  ");
        System.out.println(the_sky_is_blue);
    }

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].isBlank()) {
                continue;
            }
            stringBuilder.append(s1[i]);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length());
        return stringBuilder.toString();
    }
}
