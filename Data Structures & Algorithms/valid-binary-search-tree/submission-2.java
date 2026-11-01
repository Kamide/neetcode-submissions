final class Solution {
    public boolean isValidBST(final TreeNode root) {
        final var stack = new ArrayDeque<TreeNode>();
        var node = root;
        var value = Long.MIN_VALUE;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if (node.val <= value) {
                return false;
            }

            value = node.val;
            node = node.right;
        }

        return true;
    }
}
