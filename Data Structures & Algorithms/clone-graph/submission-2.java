class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        return clone(node, new HashMap<>());
    }

    private Node clone(Node original, Map<Node, Node> originalToClone) {
        var copy = new Node(original.val, new ArrayList<>(original.neighbors.size()));

        originalToClone.put(original, copy);

        for (var neighbor : original.neighbors) {
            if (originalToClone.containsKey(neighbor)) {
                copy.neighbors.add(originalToClone.get(neighbor));
            } else {
                copy.neighbors.add(clone(neighbor, originalToClone));
            }
        }

        return copy;
    }
}
