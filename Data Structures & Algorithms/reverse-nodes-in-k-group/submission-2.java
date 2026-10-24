class Solution {
    public ListNode reverseKGroup(final ListNode head, final int k) {
        final var dummy = new ListNode();
        dummy.next = head;

        final var group = new ListNode[k];
        var size = 0;
        var previous = dummy;
        var current = head;

        while (current != null) {
            group[size] = current;
            size += 1;
            current = current.next;

            if (size < k) {
                continue;
            }

            while (size > 0) {
                size -= 1;
                previous.next = group[size];
                previous = previous.next;
            }

            previous.next = current;
        }

        return dummy.next;
    }
}
