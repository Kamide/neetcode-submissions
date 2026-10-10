/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        var visited = new HashSet<ListNode>();

        for (var current = head; current != null; current = current.next) {
            if (!visited.add(current)) {
                return true;
            }
        }

        return false;
    }
}
