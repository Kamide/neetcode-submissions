class Solution {
    public ListNode mergeKLists(final ListNode[] heads) {
        final var minHeap = new PriorityQueue<ListNode>(
            Comparator.comparingInt(node -> node.val)
        );

        for (final var head : heads) {
            if (head != null) {
                minHeap.offer(head);
            }
        }

        final var dummy = new ListNode(0);
        var previous = dummy;

        while (!minHeap.isEmpty()) {
            final var current = minHeap.poll();

            previous.next = current;
            previous = current;

            if (current.next != null) {
                minHeap.offer(current.next);
            }
        }

        return dummy.next;
    }
}
