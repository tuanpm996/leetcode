package problems.easy;

public class Problem404 {

    public static void main(String[] args) {

    }

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left != null) {
            calculateSum(root.left, true);
        }
        if (root.right != null) {
            calculateSum(root.right, false);
        }
        return sum;
    }

    private void calculateSum(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null) {
            if (isLeft) {
                sum += node.val;
            }
        } else {
            if (node.left != null) {
                calculateSum(node.left, true);
            }
            if (node.right != null) {
                calculateSum(node.right, false);
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
