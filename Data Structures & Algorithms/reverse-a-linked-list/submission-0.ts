type LN = {
    val: number;
    next: LN | null;
};

class Solution {
    reverseList(head: LN | null): LN | null {
        let previous: LN | null = null;
        let current = head;

        while (current != null) {
            const { next } = current;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
