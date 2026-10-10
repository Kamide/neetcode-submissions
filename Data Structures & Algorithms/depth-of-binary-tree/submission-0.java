/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private record Frame(int depth, TreeNode node) {}

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var maxDepth = 0;
        var stack = new ArrayDeque<>(List.of(new Frame(1, root)));

        while (!stack.isEmpty()) {
            var frame = stack.pop();
            var depth = frame.depth;
            var node = frame.node;
            var left = node.left;
            var right = node.right;

            maxDepth = Math.max(maxDepth, depth);

            if (left != null) {
                stack.add(new Frame(depth + 1, left));
            }
            if (right != null) {
                stack.add(new Frame(depth + 1, right));
            }
        }

        return maxDepth;
    }
}