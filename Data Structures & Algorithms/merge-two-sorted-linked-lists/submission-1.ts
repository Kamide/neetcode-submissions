type LN = {
    val: number;
    next: LN | null;
};

function* traverse(head: LN | null) {
    for (let node = head; node != null; node = node.next) {
        yield node;
    }
}

function* chain<T>(left: Iterable<T>, right: Iterable<T>) {
    yield* left;
    yield* right;
}

class Solution {
    mergeTwoLists(list1: LN | null, list2: LN | null): LN | null {
        const nodes = [...chain(traverse(list1), traverse(list2))].sort((a, b) => a.val - b.val);

        for (let i = 0; i < nodes.length; i += 1) {
            nodes[i].next = nodes.at(i + 1) ?? null;
        }

        return nodes.at(0) ?? null;
    }
}
