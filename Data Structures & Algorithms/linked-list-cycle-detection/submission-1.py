# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

def traverse(node: Optional[ListNode]) -> Generator[ListNode]:
    while node:
        yield node
        node = node.next


class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        visited: set[ListNode] = set()

        for node in traverse(head):
            if node in visited:
                return True

            visited.add(node)

        return False
