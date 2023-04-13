package problems.medium;

import java.util.StringJoiner;

public class Problem449 {
    //   https://leetcode.com/problems/serialize-and-deserialize-bst/
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(6);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(7);


        Problem449 ser = new Problem449();
        Problem449 deser = new Problem449();
        String tree = ser.serialize(treeNode);
        System.out.println(tree);
        TreeNode ans = deser.deserialize(tree);
        System.out.println();
    }

    int pos = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringJoiner res = new StringJoiner(",");
        preOrderTraverse(root, res);
        return res.toString();
    }

    private void preOrderTraverse(TreeNode node, StringJoiner res) {
        if (node == null) {
            res.add("#");
        } else {
            res.add(String.valueOf(node.val));
            preOrderTraverse(node.left, res);
            preOrderTraverse(node.right, res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if (arr.length == 1) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(arr[0]));
        pos++;
        buildTree(treeNode, arr);
        return treeNode;
    }

    private void buildTree(TreeNode treeNode, String[] arr) {
        if (!arr[pos].equals("#")) {
            TreeNode leftNode = new TreeNode(Integer.parseInt(arr[pos++]));
            treeNode.left = leftNode;
            buildTree(leftNode, arr);
        } else {
            pos++;
        }

        if (!arr[pos].equals("#")) {
            TreeNode rightNode = new TreeNode(Integer.parseInt(arr[pos++]));
            treeNode.right = rightNode;
            buildTree(rightNode, arr);
        } else {
            pos++;
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
