final class Solution {
    public int maxPathSum(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        var maxPathSum = Integer.MIN_VALUE;
        final var pathSums = new HashMap<TreeNode, Integer>();
        final var visited = new HashSet<TreeNode>();
        final var stack = new ArrayDeque<TreeNode>();

        stack.add(root);

        do {
            final var node = stack.peek();

            if (visited.add(node)) {
                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                stack.pop();

                final var leftPathSum = Math.max(0, pathSums.getOrDefault(node.left, 0));
                final var rightPathSum = Math.max(0, pathSums.getOrDefault(node.right, 0));

                maxPathSum = Math.max(maxPathSum, node.val + leftPathSum + rightPathSum);
                pathSums.put(node, node.val + Math.max(leftPathSum, rightPathSum));
            }
        } while (!stack.isEmpty());

        return maxPathSum;
    }
}
