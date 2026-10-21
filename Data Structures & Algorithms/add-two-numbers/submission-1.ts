type LN = { val: number; next: LNM };
type LNM = LN | null;

function* traverse(node: LNM) {
    while (node != null) {
        yield node;
        node = node.next;
    }
}

function* values(nodes: Iterable<LN>) {
    for (const node of nodes) {
        yield node.val;
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
    addTwoNumbers(l1: LNM, l2: LNM): LNM {
        const lefts = [...values(traverse(l1))];
        const rights = [...values(traverse(l2))];
        const length = Math.max(lefts.length, rights.length);

        const sumNodes: LN[] = [];
        let carry = 0;

        for (let i = 0; i < length; i += 1) {
            const sum = (lefts[i] ?? 0) + (rights[i] ?? 0) + carry;
            sumNodes.push({ val: sum % 10, next: null });
            carry = Math.floor(sum / 10);
        }

        if (carry > 0) {
            sumNodes.push({ val: carry, next: null });
        }

        return relink(sumNodes);
    }
}
