package problems.medium;

public class Problem1008 {

    public static void main(String[] args) {
        TreeNode node = new Problem1008().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(node);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return buildFromPreorder(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildFromPreorder(int[] arr, int start, int end) {
        int val = arr[start];
        TreeNode node = new TreeNode(val);
        if (end == start) {
            return node;
        }
        int lastLeftIndex = -1;
        for (int i = start + 1; i <= end && arr[i] < val; i++) {
            lastLeftIndex = i;
        }
        if (lastLeftIndex > 0) {
            node.left = buildFromPreorder(arr, start + 1, lastLeftIndex);
            if (lastLeftIndex < end) {
                node.right = buildFromPreorder(arr, lastLeftIndex + 1, end);
            }
        } else {
            node.right = buildFromPreorder(arr, start + 1, end);
        }
        return node;
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
