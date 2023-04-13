package problems.medium;

import java.util.*;

public class Problem99 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);

        treeNode2.right = treeNode3;
        treeNode1.left = treeNode2;

        new Problem99().recoverTree(treeNode1);
    }

    public void recoverTree(TreeNode root) {
        Map<Integer, TreeNode> num2Node = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        inOrderTraverse(root, arr, num2Node);
        List<Integer> nums = new ArrayList<>();
        List<Integer> integers = new ArrayList<>(arr);
        Collections.sort(integers);
        for (int i = 0; i < arr.size(); i++) {
            if (!Objects.equals(arr.get(i), integers.get(i))) {
                nums.add(arr.get(i));
            }
        }
        TreeNode node1 = num2Node.get(nums.get(0));
        TreeNode node2 = num2Node.get(nums.get(1));
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void inOrderTraverse(TreeNode node, List<Integer> arr, Map<Integer, TreeNode> num2Node) {
        if (node.left != null) {
            inOrderTraverse(node.left, arr, num2Node);
        }
        arr.add(node.val);
        num2Node.put(node.val, node);
        if (node.right != null) {
            inOrderTraverse(node.right, arr, num2Node);
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
