final class Solution {
    public int kthSmallest(final TreeNode root, final int k) {
        final var stack = new ArrayDeque<TreeNode>();
        var node = root;
        var count = 0;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            count += 1;
            if (count == k) {
                return node.val;
            }

            node = node.right;
        }

        return Integer.MAX_VALUE;
    }
}