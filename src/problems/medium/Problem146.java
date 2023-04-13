package problems.medium;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class Problem146 {

    public static void main(String[] args) {

    }

    public static class LRUCache {

        private Deque<Integer> doublyQueue;
        private HashSet<Integer> hashSet;
        // maximum capacity of cache
        private final int CACHE_SIZE;

        LRUCache(int capacity) {
            doublyQueue = new LinkedList<>();
            hashSet = new HashSet<>();
            CACHE_SIZE = capacity;
        }

        public int get(int key) {
            return 0;
        }

        public void put(int key, int value) {
        }

    }

}
