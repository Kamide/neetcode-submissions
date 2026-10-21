class Solution {
    public Node copyRandomList(final Node head) {
        if (head == null) {
            return null;
        }

        insertClonesAfterOriginalNodes(head);
        assignRandomReferencesToClones(head);
        return restoreOriginalListAndExtractClone(head);
    }

    /*
     * Before: (A)------->(B)------->(C)
     *  After: (A)->(A')->(B)->(B')->(C)->(C')
     */
    private void insertClonesAfterOriginalNodes(final Node head) {
        for (var current = head; current != null; ) {
            var clone = new Node(current.val);
            clone.next = current.next;

            current.next = clone;
            current = clone.next;
        }
    }

    /*
     * Before:
     * (A)->(A')->(B)->(B')->(C)->(C')
     * (A)~~~~~~~~~~~~~~~~~~>(C)
     *
     * After:
     * (A)->(A')->(B)->(B')->(C)->(C')
     * (A)~~~~~~~~~~~~~~~~~~>(C)
     *      (A')~~~~~~~~~~~~~~~~~>(C')
     */
    private void assignRandomReferencesToClones(final Node head) {
        for (var current = head; current != null; current = current.next.next) {
            final var clone = current.next;

            if (current.random != null) {
                clone.random = current.random.next;
            }
        }
    }

    /*
     * Before:
     * (A)->(A')->(B)->(B')->(C)->(C')
     * (A)~~~~~~~~~~~~~~~~~~>(C)
     *      (A')~~~~~~~~~~~~~~~~~>(C')
     *
     * After:
     * (A)->(B)->(C) (A')->(B')->(C')
     * (A)~~~~~~>(C) (A')~~~~~~~>(C')
     *         RETURN A'
     */
    private Node restoreOriginalListAndExtractClone(final Node head) {
        final var root = head.next;

        for (var current = head; current != null; ) {
            final var clone = current.next;

            current.next = clone.next;

            if (clone.next != null) {
                clone.next = clone.next.next;
            }

            current = current.next;
        }

        return root;
    }
}
