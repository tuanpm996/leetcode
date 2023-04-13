import java.util.HashMap;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        Hashtable<Integer, Integer> map = new Hashtable<>();
    }

    public int maxProfit(int[] prices) {
        int[] subs = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            subs[i] = prices[i + 1] - prices[i];
        }
        int res = 0;
        int sum = 0;
        for (int sub : subs) {
            sum += sub;
            if (sum > 0) {
                res = Math.max(sum, res);
            } else {
                sum = 0;
            }
        }
        return res;
    }
}
