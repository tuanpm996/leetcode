package problems.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Problem101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return isSymmetric(root.left, root.right);

    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.add(left);
        rightQueue.add(right);
        while (!leftQueue.isEmpty()) {
            int leftSize = leftQueue.size();
            int rightSize = rightQueue.size();
            if (leftSize != rightSize) {
                return false;
            }
            while (leftSize-- > 0) {
                TreeNode leftNode = leftQueue.poll();
                TreeNode rightNode = rightQueue.poll();
                if (leftNode.val != rightNode.val) {
                    return false;
                }
                if (leftNode.left != null && rightNode.right == null) {
                    return false;
                }
                if (leftNode.left == null && rightNode.right != null) {
                    return false;
                }
                if (leftNode.right != null && rightNode.left == null) {
                    return false;
                }
                if (leftNode.right == null && rightNode.left != null) {
                    return false;
                }
                if (leftNode.left != null) {
                    leftQueue.add(leftNode.left);
                    rightQueue.add(rightNode.right);
                }
                if (rightNode.right != null) {
                    leftQueue.add(leftNode.right);
                    rightQueue.add(rightNode.left);
                }
            }
        }
        return true;
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
