package problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem981 {
    public static void main(String[] args) {

    }


    public static class TimeMap {

        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, s -> new TreeMap<>());
            TreeMap<Integer, String> timestamp2Value = map.get(key);
            timestamp2Value.put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> integerStringTreeMap = map.get(key);
            if (integerStringTreeMap == null) {
                return "";
            }
            Map.Entry<Integer, String> entry = integerStringTreeMap.floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
}
