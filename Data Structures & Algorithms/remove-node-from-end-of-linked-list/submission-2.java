class Solution {
    public ListNode removeNthFromEnd(final ListNode head, final int n) {
        final var length = linkedListLength(head);
        final var nthFromEnd = length - n;

        if (nthFromEnd == 0) {
            return head.next;
        }

        final var previous = nodeAt(head, nthFromEnd - 1);
        previous.next = previous.next.next;

        return head;
    }

    public int linkedListLength(final ListNode head) {
        var length = 0;

        for (var current = head; current != null; current = current.next) {
            length += 1;
        }

        return length;
    }

    private ListNode nodeAt(final ListNode head, int index) {
        var current = head;

        for (; index > 0; index -= 1) {
            current = current.next;
        }

        return current;
    }
}
