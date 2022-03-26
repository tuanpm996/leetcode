package problems.medium;

import java.util.*;

public class Problem692 {

    public static void main(String[] args) {
        String[] strings = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> strings1 = new Problem692().topKFrequent(strings, 2);
        System.out.println(Arrays.toString(strings1.toArray(new String[]{})));

    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> s2Count = new TreeMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!s2Count.containsKey(word)) {
                s2Count.put(word, 1);
            } else {
                s2Count.put(word, s2Count.get(word) + 1);
            }
        }

        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        pq.addAll(s2Count.entrySet());
        List<String> results = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            results.add(pq.poll().getKey());
        }
        return results;
    }
}
