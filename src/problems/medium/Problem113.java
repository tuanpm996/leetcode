package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem113 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        return findPathSum(root, targetSum);
    }

    private List<List<Integer>> findPathSum(TreeNode node, int targetSum) {
        if (node.left == null && node.right == null) {
            return node.val == targetSum ? Collections.singletonList(Collections.singletonList(node.val)) : Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        if (node.left != null) {
            List<List<Integer>> leftPath = findPathSum(node.left, targetSum - node.val);
            findSumPath(node, res, leftPath);
        }

        if (node.right != null) {
            List<List<Integer>> rightPath = findPathSum(node.right, targetSum - node.val);
            findSumPath(node, res, rightPath);
        }
        return res;
    }

    private void findSumPath(TreeNode node, List<List<Integer>> res, List<List<Integer>> path) {
        if (!path.isEmpty()) {
            for (List<Integer> right : path) {
                List<Integer> integers = new ArrayList<>(right);
                integers.add(0, node.val);
                res.add(integers);
            }
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
