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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var diameter = 0;
        var stack = new ArrayDeque<>(List.of(root));
        var heights = new HashMap<>(Map.of(root, 1));

        while (!stack.isEmpty()) {
            var node = stack.peek();
            var left = node.left;
            var right = node.right;

            if (left != null && !heights.containsKey(left)) {
                stack.push(left);
                continue;
            }

            if (right != null && !heights.containsKey(right)) {
                stack.push(right);
                continue;
            }

            stack.pop();

            var leftHeight = left == null ? 0 : heights.get(left);
            var rightHeight = right == null ? 0 : heights.get(right);
            heights.put(node, 1 + Math.max(leftHeight, rightHeight));

            diameter = Math.max(diameter, leftHeight + rightHeight);
        }

        return diameter;
    }
}
