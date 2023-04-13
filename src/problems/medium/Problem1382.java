package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1382 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;

        TreeNode node = new Problem1382().balanceBST(node1);
        System.out.println(node.val);
    }

    List<Integer> arr = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return buildBST(arr, 0, arr.size() - 1);
    }

    private TreeNode buildBST(List<Integer> arr, int start, int end) {
        if (start == end) {
            return new TreeNode(arr.get(start));
        }
        int mid = (start + end) / 2;
        if (start == mid) {
            TreeNode node = new TreeNode(arr.get(start));
            node.right = new TreeNode(arr.get(end));
            return node;
        }
        TreeNode left = buildBST(arr, start, mid - 1);
        TreeNode right = buildBST(arr, mid + 1, end);
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = left;
        node.right = right;
        return node;
    }

    private void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        arr.add(node.val);
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    private static class TreeNode {
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
