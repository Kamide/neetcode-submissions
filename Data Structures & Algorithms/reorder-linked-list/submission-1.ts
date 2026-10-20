type LN = { val: number; next: LNM };
type LNM = LN | null;

function* traverse(node: LNM) {
    while (node) {
        yield node;
        node = node.next;
    }
}

function relink(nodes: LN[]) {
    for (let i = 0; i < nodes.length - 1; i += 1) {
        nodes[i].next = nodes[i + 1];
    }

    if (nodes.length > 0) {
        nodes[nodes.length - 1].next = null;
    }
}

class Solution {
    reorderList(head: LNM) {
        const original = [...traverse(head)];
        const reordered: LN[] = [];

        let left = 0;
        let right = original.length - 1;

        while (left <= right) {
            reordered.push(original[left]);
            left += 1;

            if (left <= right) {
                reordered.push(original[right]);
                right -= 1;
            }
        }

        relink(reordered);
    }
}
