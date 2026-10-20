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
    removeNthFromEnd(head: LNM, n: number): LNM {
        const nodes = [...traverse(head)];
        nodes.splice(nodes.length - n, 1);
        relink(nodes);
        return nodes[0] ?? null;
    }
}
