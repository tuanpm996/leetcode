package problems.easy;

import java.util.Stack;

public class Problem112 {

    public static void main(String[] args) {
        Problem112 problem104 = new Problem112();
        TreeNode treeNode = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        boolean b = problem104.hasPathSum(treeNode, 30);
        System.out.println(b);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            if (node.left != null || node.right != null) {
                if (node.left != null) {
                    stack.push(node.left);
                    value.push(temp + node.left.val);
                }
                if (node.right != null) {
                    stack.push(node.right);
                    value.push(temp + node.right.val);
                }
            } else if (temp == targetSum) {
                return true;
            }
        }
        return false;
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
