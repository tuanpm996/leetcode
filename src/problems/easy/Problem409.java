package problems.easy;

public class Problem409 {

    public static void main(String[] args) {
        int res = new Problem409().longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
        System.out.println(res);
    }

    public int longestPalindrome(String s) {
        int[] counts = new int[200];
        for (char aChar : s.toCharArray()) {
            counts[aChar - 'A']++;
        }
        int max = 0;
        int num = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            if (count % 2 == 0) {
                num += count;
                System.out.println("even " + count);
            } else {
                max = Math.max(max, count);
                System.out.println("odd " + count);
            }
        }
        return max + num;
    }
}
