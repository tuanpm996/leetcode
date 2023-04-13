package problems.easy;

public class Problem700 {

    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode node, int val) {
        if (node.val == val) {
            return node;
        }
        if (val < node.val) {
            return node.left != null ? searchBST(node.left, val) : null;
        }
        return node.right != null ? searchBST(node.right, val) : null;
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
