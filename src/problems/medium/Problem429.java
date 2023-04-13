package problems.medium;

import java.util.*;

public class Problem429 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> subRes = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                subRes.add(node.val);
                if (node.children != null && !node.children.isEmpty()) {
                    queue.addAll(node.children);
                }
            }
            res.add(subRes);
        }
        return res;

    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
