package problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Problem111 {

    public static void main(String[] args) {

    }

    //    https://leetcode.com/problems/minimum-depth-of-binary-tree/
    private int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNodeData> queue = new LinkedList<>();
        queue.add(new TreeNodeData(root, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNodeData nodeData = queue.poll();
                TreeNode node = nodeData.treeNode;
                if (node.left == null && node.right == null) {
                    minDepth = Math.min(minDepth, nodeData.depth);
                } else {
                    if (node.left != null) {
                        queue.add(new TreeNodeData(node.left, nodeData.depth + 1));
                    }
                    if (node.right != null) {
                        queue.add(new TreeNodeData(node.right, nodeData.depth + 1));
                    }
                }
            }
        }
        return minDepth;
    }

    private static class TreeNodeData {
        private TreeNode treeNode;
        private int depth;

        private TreeNodeData(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
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
