
class Solution {
    public ListNode addTwoNumbers(ListNode left, ListNode right) {
        final var dummy = new ListNode(0);
        var current = dummy;
        var carry = 0;

        while (left != null || right != null || carry != 0) {
            var sum = carry;

            if (left != null) {
                sum += left.val;
                left = left.next;
            }

            if (right != null) {
                sum += right.val;
                right = right.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}
