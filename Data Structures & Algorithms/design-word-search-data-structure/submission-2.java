class WordDictionary {
    private static class Node {
        final Map<Integer, Node> children = new HashMap<>();
        boolean leaf = false;
    }

    private final Node root = new Node();

    public void addWord(final String word) {
        var node = root;
        final var iterator = word.codePoints().iterator();

        while (iterator.hasNext()) {
            final var codePoint = iterator.nextInt();

            node = node.children.computeIfAbsent(codePoint, unused -> new Node());
        }

        node.leaf = true;
    }

    private record Frame(Node node, int codePointIndex) {
    }

    public boolean search(final String word) {
        final var codePoints = word.codePoints().toArray();
        final var stack = new ArrayDeque<Frame>();

        stack.push(new Frame(root, 0));

        while (!stack.isEmpty()) {
            final var frame = stack.pop();
            final var node = frame.node();
            final var codePointIndex = frame.codePointIndex();

            if (codePointIndex == codePoints.length) {
                if (node.leaf) {
                    return true;
                }

                continue;
            }

            final var codePoint = codePoints[codePointIndex];

            if (codePoint == '.') {
                for (final var child : node.children.values()) {
                    stack.push(new Frame(child, codePointIndex + 1));
                }
            } else {
                final var child = node.children.get(codePoint);

                if (child != null) {
                    stack.push(new Frame(child, codePointIndex + 1));
                }
            }
        }

        return false;
    }
}
