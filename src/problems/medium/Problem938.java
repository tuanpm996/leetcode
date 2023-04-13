package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem938 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, null);
        int i = new Problem938().rangeSumBST(treeNode, 1, 1);
        System.out.println(i);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
//        return calculateResult(root, low, high);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.val >= low && node.val <= high) {
                    res += node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                queue.add(node.right);
                }
                size--;
            }
        }
        return res;
    }

    private int calculateResult(TreeNode node, int low, int high) {
        int res = 0;
        if (node.val >= low && node.val <= high) {
            res = node.val;
        }
        if (node.left != null && node.val > low) {
            res += calculateResult(node.left, low, high);
        }
        if (node.right != null && node.val < high) {
            res += calculateResult(node.right, low, high);
        }
        return res;
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
