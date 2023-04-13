package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem897 {
    public static void main(String[] args) {

    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inOrder(root, vals);
        TreeNode curNode = null;
        TreeNode newRoot = null;
        for (Integer val : vals) {
            if (newRoot == null) {
                newRoot = new TreeNode(val);
                curNode = newRoot;
            } else {
                curNode.right = new TreeNode(val);
                curNode = curNode.right;
            }
        }
        return newRoot;
    }

    private void inOrder(TreeNode node, List<Integer> vals) {
        if (node.left != null) {
            inOrder(node.left, vals);
        }
        vals.add(node.val);
        if (node.right != null) {
            inOrder(node.right, vals);
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
