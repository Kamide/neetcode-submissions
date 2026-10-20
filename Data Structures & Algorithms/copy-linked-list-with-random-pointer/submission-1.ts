type N = { val: number; next: NM; random: NM };
type NM = N | null;

function copy(original: NM, originalToClone: Map<N, N>): NM {
    if (original == null) {
        return null;
    }

    let clone = originalToClone.get(original);

    if (clone != null) {
        return clone;
    }

    clone = {
        val: original.val,
        next: null,
        random: null,
    };

    originalToClone.set(original, clone);

    clone.next = copy(original.next, originalToClone);
    clone.random = copy(original.random, originalToClone);

    return clone;
}

class Solution {
    copyRandomList = (head: NM) => copy(head, new Map());
}
