package problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem235 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node8;
        node2.left = node0;
        node2.right = node4;
        node8.left = node7;
        node8.right = node9;
        node4.left = node3;
        node4.right = node5;
        TreeNode node = new Problem235().lowestCommonAncestor(root, node3, node0);
        System.out.println(node.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = findPath(root, p);
        List<TreeNode> path2 = findPath(root, q);
        TreeNode res = null;
        int size = Math.min(path2.size(), path1.size());
        for (int i = 0; i < size && (path1.get(path1.size() - 1 - i) == path2.get(path2.size() - 1 - i)); i++) {
            res = path1.get(path1.size() - 1 - i);
        }
        return res;
    }

    private List<TreeNode> findPath(TreeNode node, TreeNode target) {
        if (node.left != null) {
            List<TreeNode> leftPath = findPath(node.left, target);
            if (!leftPath.isEmpty()) {
                leftPath.add(node);
                return leftPath;
            }
        }

        if (node == target) {
            return new ArrayList<>() {{
                add(node);
            }};
        }

        if (node.right != null) {
            List<TreeNode> rightPath = findPath(node.right, target);
            if (!rightPath.isEmpty()) {
                rightPath.add(node);
                return rightPath;
            }
        }
        return Collections.emptyList();
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
