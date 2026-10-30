final class Solution {
    private static final class Frame {
        enum State { FORK_LEFT, FORK_RIGHT, JOIN }

        final TreeNode node;
        TreeNode left;
        TreeNode right;
        State state = State.FORK_LEFT;

        Frame(TreeNode node) {
            this.node = node;
        }
    }

    public TreeNode lowestCommonAncestor(final TreeNode root, final TreeNode p, final TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        TreeNode ancestor = null;
        final var stack = new ArrayDeque<Frame>();
        stack.push(new Frame(root));

        while (!stack.isEmpty()) {
            final var frame = stack.peek();

            switch (frame.state) {
                case FORK_LEFT -> {
                    frame.state = Frame.State.FORK_RIGHT;

                    if (frame.node.left != null) {
                        stack.push(new Frame(frame.node.left));
                    }
                }

                case FORK_RIGHT -> {
                    frame.state = Frame.State.JOIN;

                    if (frame.node.right != null) {
                        stack.push(new Frame(frame.node.right));
                    }
                }

                case JOIN -> {
                    if (frame.node == p || frame.node == q) {
                        ancestor = frame.node;
                    } else if (frame.left != null && frame.right != null) {
                        ancestor = frame.node;
                    } else {
                        ancestor = frame.left != null ? frame.left : frame.right;
                    }

                    stack.pop();

                    if (!stack.isEmpty()) {
                        final var parent = stack.peek();

                        if (parent.state == Frame.State.FORK_RIGHT) {
                            parent.left = ancestor;
                        } else {
                            parent.right = ancestor;
                        }
                    }
                }
            }
        }

        return ancestor;
    }
}
