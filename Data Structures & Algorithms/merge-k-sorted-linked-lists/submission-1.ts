type LN = { val: number; next: LNM };
type LNM = LN | null;

function* traverse(node: LNM) {
    while (node) {
        yield node;
        node = node.next;
    }
}

function relink(nodes: LN[]) {
    const { length } = nodes;

    if (length === 0) {
        return null;
    }

    const last = length - 1;

    for (let i = 0; i < last; i += 1) {
        nodes[i].next = nodes[i + 1];
    }

    nodes[last].next = null;

    return nodes[0];
}

class Solution {
    mergeKLists(lists: LNM[]): LNM {
        return relink(
            [
                ...(function* () {
                    for (const list of lists) {
                        yield* traverse(list);
                    }
                })(),
            ].sort((a, b) => a.val - b.val),
        );
    }
}
