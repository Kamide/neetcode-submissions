type Node_ = { val: number; neighbors: Node_[] };
type Node_Maybe = Node_ | null;

function clone(original: Node_, originalToClone: Map<Node_, Node_>) {
    if (original == null) {
        return null;
    }

    const copy = { val: original.val } as Node_;

    originalToClone.set(original, copy);

    copy.neighbors = original.neighbors.map(
        (node) => originalToClone.get(node) ?? clone(node, originalToClone),
    );

    return copy;
}

class Solution {
    cloneGraph(node: Node_Maybe) {
        if (node == null) {
            return null;
        }

        return clone(node, new Map());
    }
}
