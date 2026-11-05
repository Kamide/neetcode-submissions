final class Solution {
    public TreeNode buildTree(final int[] preorder, final int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        final var root = new TreeNode(preorder[0]);
        final var stack = new ArrayDeque<TreeNode>();
        stack.push(root);

        for (
            int preorderIndex = 1, inorderIndex = 0;
            preorderIndex < preorder.length && !stack.isEmpty();
            preorderIndex += 1
        ) {
            final var value = preorder[preorderIndex];
            var node = stack.peek();

            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(value);
                stack.push(node.left);
            } else {
                for (
                    ;
                    !stack.isEmpty() && stack.peek().val == inorder[inorderIndex];
                    inorderIndex += 1
                ) {
                    node = stack.pop();
                }

                node.right = new TreeNode(value);
                stack.push(node.right);
            }

        }

        return root;
    }
}
