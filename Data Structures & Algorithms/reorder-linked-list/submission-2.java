class Solution {
    public void reorderList(final ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        final var middle = findMiddleNode(head);
        final var secondHalf = middle.next;

        middle.next = null;

        relinkHalvesAlternating(head, reverseLinkedList(secondHalf));
    }

    private ListNode findMiddleNode(final ListNode head) {
        var slow = head;

        for (
            var fast = head;
            fast.next != null && fast.next.next != null;
            fast = fast.next.next
        ) {
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseLinkedList(final ListNode head) {
        ListNode previous = null;

        for (var current = head; current != null; ) {
            final var next = current.next;

            current.next = previous;
            previous = current;

            current = next;
        }

        return previous;
    }

    private void relinkHalvesAlternating(ListNode firstHalf, ListNode secondHalf) {
        while (secondHalf != null) {
            final var nextFirst = firstHalf.next;
            final var nextSecond = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = nextFirst;

            firstHalf = nextFirst;
            secondHalf = nextSecond;
        }
    }
}
