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

function* chunks<T>(items: Iterable<T>, size: number) {
    let chunk: T[] = [];

    for (const item of items) {
        chunk.push(item);

        if (chunk.length === size) {
            yield chunk;
            chunk = [];
        }
    }

    if (chunk.length > 0) {
        yield chunk;
    }
}

class Solution {
    reverseKGroup(head: LNM, k: number): LNM {
        return relink(
            [...chunks(traverse(head), k)].flatMap((chunk) => {
                if (chunk.length === k) {
                    return chunk.reverse();
                }
                return chunk;
            }),
        );
    }
}
