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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        var stack = new ArrayList<TreeNode>();
        stack.add(p);
        stack.add(q);

        while (!stack.isEmpty()) {
            var b = stack.removeLast();
            var a = stack.removeLast();

            if (a == null && b == null) {
                continue;
            }

            if (a == null || b == null || a.val != b.val) {
                return false;
            }

            stack.add(a.right);
            stack.add(b.right);

            stack.add(a.left);
            stack.add(b.left);
        }

        return true;
    }
}
