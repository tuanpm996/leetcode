package problems.medium;

public class Problem230 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        int i = new Problem230().kthSmallest(root, 1);
        System.out.println(i);
    }

    public int kthSmallest(TreeNode root, int k) {
        target = k;
        return inOrder(root);
    }

    private int inOrder(TreeNode node) {
        if (node.left != null) {
            int val = inOrder(node.left);
            if (val != -1) {
                return val;
            }
        }
        count++;
        if (count == target) {
            return node.val;
        }
        if (node.right != null) {
            int val = inOrder(node.right);
            if (val != -1) {
                return val;
            }
        }
        return -1;
    }

    int count = 0;
    int target;

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
