package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1315 {

    public static void main(String[] args) {

    }

    public int sumEvenGrandparent(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.val % 2 == 0) {
                    if (node.left != null) {
                        TreeNode leftNode = node.left;
                        if (leftNode.left != null) {
                            res += leftNode.left.val;
                        }
                        if (leftNode.right != null) {
                            res += leftNode.right.val;
                        }
                    }

                    if (node.right != null) {
                        TreeNode rightNode = node.right;
                        if (rightNode.left != null) {
                            res += rightNode.left.val;
                        }
                        if (rightNode.right != null) {
                            res += rightNode.right.val;
                        }
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
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
