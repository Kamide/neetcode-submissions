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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        var stack = new ArrayDeque<>(List.of(root));

        while (!stack.isEmpty()) {
            var node = stack.pop();
            var left = node.left;
            var right = node.right;

            node.left = right;
            node.right = left;

            if (left != null) {
                stack.add(left);
            }
            if (right != null) {
                stack.add(right);
            }
        }

        return root;
    }
}
