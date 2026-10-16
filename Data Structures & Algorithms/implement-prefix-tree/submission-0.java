class PrefixTree {
    private static class Node {
        Map<Integer, Node> children;
        boolean leaf;

        public Node() {
            children = new HashMap<>();
            leaf = false;
        }
    }

    private final Node root;

    public PrefixTree() {
        root = new Node();
        root.leaf = true;
    }

    public void insert(String word) {
        var current = root;
        var iterator = word.codePoints().iterator();

        while (iterator.hasNext()) {
            var codePoint = iterator.nextInt();

            current = current.children.computeIfAbsent(codePoint, unused -> new Node());
        }

        current.leaf = true;
    }

    public boolean search(String word) {
        var current = root;
        var iterator = word.codePoints().iterator();

        while (iterator.hasNext()) {
            var codePoint = iterator.nextInt();

            if (!current.children.containsKey(codePoint)) {
                return false;
            }

            current = current.children.get(codePoint);
        }

        return current.leaf;
    }

    public boolean startsWith(String prefix) {
        var current = root;
        var iterator = prefix.codePoints().iterator();

        while (iterator.hasNext()) {
            var codePoint = iterator.nextInt();

            if (!current.children.containsKey(codePoint)) {
                return false;
            }

            current = current.children.get(codePoint);
        }

        return true;
    }
}
