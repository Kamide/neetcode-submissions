final class Solution {
    private record Frame(TreeNode node, int depth) {}

    public List<Integer> rightSideView(final TreeNode root) {
        final var visible = new ArrayList<Integer>();

        if (root == null) {
            return visible;
        }

        final var queue = new ArrayDeque<Frame>();
        queue.add(new Frame(root, 0));

        while (!queue.isEmpty()) {
            final var frame = queue.poll();
            final var node = frame.node();
            final var depth = frame.depth();

            if (visible.size() == depth) {
                visible.add(node.val);
            } else {
                visible.set(depth, node.val);
            }

            if (node.left != null) {
                queue.add(new Frame(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.add(new Frame(node.right, depth + 1));
            }
        }

        return visible;
    }
}
