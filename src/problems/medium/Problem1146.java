package problems.medium;

import java.util.TreeMap;

public class Problem1146 {

    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0, 5);  // Set array[0] = 5
        int snap = snapshotArr.snap();// Take a snapshot, return snap_id = 0
        System.out.println("snap: " + snap);
        snapshotArr.set(0, 6);
        int result = snapshotArr.get(0, 0);// Get the value of array[0] with snap_id = 0, return 5
        System.out.println("result: " + result);
    }


    private static class SnapshotArray {
        TreeMap<Integer, Integer>[] snapshots;
        int snap_id = 0;

        public SnapshotArray(int length) {
            snapshots = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                snapshots[i] = new TreeMap<>();
                snapshots[i].put(0, 0);
            }
        }

        public void set(int index, int val) {
            snapshots[index].put(snap_id, val);
        }

        public int snap() {
            return snap_id++;
        }

        public int get(int index, int snapId) {
            return snapshots[index].floorEntry(snapId).getValue();
        }
    }
}
