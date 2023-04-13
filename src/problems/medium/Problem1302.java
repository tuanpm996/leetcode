package problems.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1302 {

    public static void main(String[] args) {

    }

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> tempNodes = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                tempNodes.add(queue.poll());
            }
            boolean isAllLeaf = true;
            for (TreeNode tempNode : tempNodes) {
                if (tempNode.left != null || tempNode.right != null) {
                    isAllLeaf = false;
                    break;
                }
            }
            if (isAllLeaf) {
                return tempNodes.stream().mapToInt(t -> t.val).sum();
            }
            for (TreeNode tempNode : tempNodes) {
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return -1;
    }

    public class TreeNode {
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
