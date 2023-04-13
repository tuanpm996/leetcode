package problems.easy;

public class Problem108 {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
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
