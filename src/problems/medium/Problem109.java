package problems.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem109 {
    //    https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
    public static void main(String[] args) {
        String sample = "-10,-3,0,5,9";
        String[] strings = sample.split(",");
        ListNode lastNode = null;
        ListNode head = null;
        for (String val : strings) {
            int num = Integer.parseInt(val);
            if (lastNode == null) {
                lastNode = new ListNode(num);
                head = lastNode;
            } else {
                lastNode.next = new ListNode(num);
                lastNode = lastNode.next;
            }
        }
        new Problem109().sortedListToBST(head);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        //convert to array list
        List<Integer> list = convertToArrayList(head);
        int[] array = list.stream().mapToInt(t -> t).toArray();
        return buildBST(array);
    }

    private TreeNode buildBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        if (mid == start) {
            TreeNode leafNode = new TreeNode(nums[end]);
            TreeNode treeNode = new TreeNode(nums[start]);
            treeNode.right = leafNode;
            return treeNode;
        }
        TreeNode leftTree = buildBST(nums, start, mid - 1);
        TreeNode rightTree = buildBST(nums, mid + 1, end);
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = leftTree;
        treeNode.right = rightTree;
        return treeNode;
    }

    private List<Integer> convertToArrayList(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode node = head;
        do {
            arr.add(node.val);
            node = node.next;
        } while (node != null);
        return arr;
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

    private static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
