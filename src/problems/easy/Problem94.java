package problems.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem94 {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        traverseInorder(root, res);
        return res;
    }

    private void traverseInorder(TreeNode node, List<Integer> res) {
        if (node.left != null) {
            traverseInorder(node.left, res);
        }
        res.add(node.val);
        if (node.right != null) {
            traverseInorder(node.right, res);
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
