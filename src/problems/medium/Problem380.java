package problems.medium;

import java.util.*;

public class Problem380 {

    public static void main(String[] args) {

    }

    public static class RandomizedSet {

        private Map<Integer, Integer> val2PosMap;
        private List<Integer> valueList;
        private Random rand;

        public RandomizedSet() {
            val2PosMap = new HashMap<>();
            valueList = new ArrayList<>();
            rand = new Random();
        }

        public boolean insert(int val) {
            if (val2PosMap.containsKey(val)) {
                return false;
            }
            val2PosMap.put(val, valueList.size());
            valueList.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!val2PosMap.containsKey(val)) {
                return false;
            }
            // move the last element to the place idx of the element to delete
            int lastElement = valueList.get(valueList.size() - 1);
            int idx = val2PosMap.get(val);
            valueList.set(idx, lastElement);
            val2PosMap.put(lastElement, idx);
            // delete the last element
            valueList.remove(valueList.size() - 1);
            val2PosMap.remove(val);
            return true;
        }

        public int getRandom() {
            return valueList.get(rand.nextInt(valueList.size()));
        }
    }
}
