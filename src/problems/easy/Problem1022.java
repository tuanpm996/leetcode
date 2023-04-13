package problems.easy;

import java.util.Stack;

public class Problem1022 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(0,
                        new TreeNode(0, null, null), new TreeNode(1, null, null)),
                new TreeNode(1,
                        new TreeNode(0, null, null), new TreeNode(1, null, null)));
        int i = new Problem1022().sumRootToLeaf(treeNode);

    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                stringBuilder.append(node.val);
                System.out.println(stringBuilder.toString());
            } else {
                if (stringBuilder.length() > 0 ){
                    stringBuilder.deleteCharAt(stringBuilder.length() -1);
                }
                stringBuilder.append(node.val);
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }

        }
        return 0;
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
