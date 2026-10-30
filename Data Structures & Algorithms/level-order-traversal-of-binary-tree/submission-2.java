final class Solution {
    private record Frame(TreeNode node, int depth) {}

    public List<List<Integer>> levelOrder(final TreeNode root) {
        var levels = new ArrayList<List<Integer>>();

        if (root == null) {
            return levels;
        }

        final var queue = new ArrayDeque<Frame>();
        queue.add(new Frame(root, 0));

        while (!queue.isEmpty()) {
            final var frame = queue.poll();
            final var node = frame.node();
            final var depth = frame.depth();

            if (levels.size() == depth) {
                levels.add(new ArrayList<>());
            }

            levels.get(depth).add(node.val);

            if (node.left != null) {
                queue.add(new Frame(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.add(new Frame(node.right, depth + 1));
            }
        }

        return levels;
    }
}
