package problems.easy;

public class Problem530 {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        int minimumDifference = new Problem530().getMinimumDifference(node1);
        System.out.println(minimumDifference);
    }

    int res = Integer.MAX_VALUE;
    TreeNode lastNode;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        if (lastNode != null) {
            res = Math.min(Math.abs(node.val - lastNode.val), res);
        }
        lastNode = node;
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
