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
    public boolean isBalanced(TreeNode root) {
        return balancedHeightOf(root).isPresent();
    }

    private Optional<Integer> balancedHeightOf(TreeNode node) {
        if (node == null) {
            return Optional.of(0);
        }

        return balancedHeightOf(node.left).flatMap(left
            -> balancedHeightOf(node.right)
                .filter(right -> Math.abs(left - right) <= 1)
                .map(right -> 1 + Math.max(left, right)));
    }
}
