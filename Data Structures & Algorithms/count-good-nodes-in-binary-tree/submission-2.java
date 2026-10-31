final class Solution {
    private record Frame(TreeNode node, int max) {}

    public int goodNodes(final TreeNode root) {
        var count = 0;

        if (root == null) {
            return count;
        }

        final var stack = new ArrayDeque<Frame>();
        stack.add(new Frame(root, root.val));

        do {
            final var frame = stack.pop();
            final var node = frame.node();
            var max = frame.max();

            if (node.val >= max) {
                count += 1;
                max = node.val;
            }

            if (node.left != null) {
                stack.add(new Frame(node.left, max));
            }
            if (node.right != null) {
                stack.add(new Frame(node.right, max));
            }
        } while (!stack.isEmpty());

        return count;
    }
}
