package problems.medium;

public class Problem875 {

    public static void main(String[] args) {
        int eatTime = new Problem875().minEatingSpeed(new int[]{848219518, 588431922, 679783979, 432047681, 558963869, 874763943, 356682090, 514921461, 639400033, 842625686, 737707391, 663203571, 195860905, 278665278, 886595950, 837136539, 649029499, 866615005, 314734742, 888429433, 348422147, 634905317, 222096525, 926976060, 731794241, 636342449, 57112531, 790567866, 296797429, 756486656, 972612015, 439134823, 20840594, 812172762, 722611086, 617646271, 594776717, 912921645, 892159640, 674448885, 645585171, 658634155, 78508257, 946709338, 376077435, 846624429, 996828412, 236496810, 946919361, 414390039, 60947718, 973801466, 452874238, 334628044, 117140771, 402855733, 278663893, 259369536, 159585958, 501119979, 992853641, 292301385, 614052668, 417035905, 172421780, 669155352, 214329208, 96847320, 398325069, 739265267, 444152648, 820224819, 741012408, 656370372, 750877554, 562792394, 269958723, 158621149, 242126959, 211043846, 48918663, 759208762, 16593653, 233539975}, 558918813);
        System.out.println(eatTime);

    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int middle = (left + right) / 2;
            int hourSpent = 0;
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return right;

    }

    public int findEatTime(int[] piles, int speed) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile / speed + ((pile % speed == 0) ? 0 : 1);
        }
        return sum;
    }
}
