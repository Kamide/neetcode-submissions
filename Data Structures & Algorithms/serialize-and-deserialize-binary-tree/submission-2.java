final public class Codec {
    public static final String DELIMITER = " ";
    public static final String NULL_MARKER = "_";

    public String serialize(final TreeNode root) {
        final var builder = new StringBuilder();

        serializeDFS(root, builder);

        return builder.toString().trim();
    }

    private void serializeDFS(final TreeNode node, final StringBuilder builder) {
        if (node == null) {
            builder.append(NULL_MARKER);
            builder.append(DELIMITER);
            return;
        }

        builder.append(node.val);
        builder.append(DELIMITER);

        serializeDFS(node.left, builder);
        serializeDFS(node.right, builder);
    }

    public TreeNode deserialize(final String data) {
        final var values = data.split(DELIMITER);
        final var index = new int[] {0};

        return deserializeDFS(values, index);
    }

    private TreeNode deserializeDFS(final String[] values, final int[] index) {
        final var value = values[index[0]];

        index[0] += 1;

        if (NULL_MARKER.equals(value)) {
            return null;
        }

        final var node = new TreeNode(Integer.parseInt(value));

        node.left = deserializeDFS(values, index);
        node.right = deserializeDFS(values, index);

        return node;
    }
}