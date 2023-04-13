package problems.medium;

import java.util.SortedSet;
import java.util.TreeSet;

public class Problem2424 {
    public static void main(String[] args) {
        LUPrefix server = new LUPrefix(4);   // Initialize a stream of 4 videos.
        server.upload(3);                    // Upload video 3.
        System.out.println(server.longest());
        // Since video 1 has not been uploaded yet, there is no prefix.
        // So, we return 0.
        server.upload(1);                    // Upload video 1.
        System.out.println(server.longest());
        server.upload(2);                    // Upload video 2.
        System.out.println(server.longest());
        // The prefix [1,2,3] is the longest uploaded prefix, so we return 3.
    }

    private static class LUPrefix {
        public LUPrefix(int n) {

        }

        public void upload(int video) {

        }

        public int longest() {
            return 1;
        }
    }


}
