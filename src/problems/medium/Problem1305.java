package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1305 {

    List<Integer> arr1 = new ArrayList<>();
    List<Integer> arr2 = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inOrder(root1, arr1);
        inOrder(root2, arr2);
        List<Integer> res = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < arr1.size() || i2 < arr2.size()) {
            if (i1 >= arr1.size()) {
                res.add(arr2.get(i2++));
            } else if (i2 >= arr2.size()) {
                res.add(arr1.get(i1++));
            } else if (arr1.get(i1) < arr2.get(i2)) {
                res.add(arr1.get(i1++));
            } else if (arr1.get(i1) > arr2.get(i2)) {
                res.add(arr2.get(i2++));
            } else {
                res.add(arr1.get(i1++));
                res.add(arr2.get(i2++));
            }
        }
        return res;
    }

    private void inOrder(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(node.left, arr);
        }
        arr.add(node.val);
        if (node.right != null) {
            inOrder(node.right, arr);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
