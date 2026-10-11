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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return Collections.indexOfSubList(toArrayList(root), toArrayList(subRoot)) >= 0;
    }

    private ArrayList<Integer> toArrayList(TreeNode root) {
        var list = new ArrayList<Integer>();
        var stack = new LinkedList<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            var node = stack.pop();

            if (node == null) {
                list.add(null);
                continue;
            }

            list.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }

        return list;
    }
}
