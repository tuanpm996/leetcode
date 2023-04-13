package problems.medium;

import java.util.Stack;

public class Problem1038 {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3);
        TreeNode node8 = new TreeNode(8);
        node4.left = node1;
        node4.right = node6;
        node1.left = node0;
        node1.right = node2;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;
        node7.right = node8;

        TreeNode treeNode = new Problem1038().bstToGst(node4);
        System.out.println(treeNode);
    }

    TreeNode curr;

    Stack<TreeNode> stack = new Stack<>();

    void testStack(TreeNode treeNode) {
        TreeNode curr = treeNode;
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            if (curr.left != null) {
                curr = curr.left;
                stack.push(curr.left);
            }
            stack.push(curr);
            if (curr.right != null) {
                curr = curr.right;
                stack.push(curr.right)
            }
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        reverseInOrder(root);
        return root;
    }

    private void reverseInOrder(TreeNode node) {
        if (node.right != null) {
            reverseInOrder(node.right);
        }
        if (curr != null) {
            node.val += curr.val;
        }
        curr = node;
        if (node.left != null) {
            reverseInOrder(node.left);
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
