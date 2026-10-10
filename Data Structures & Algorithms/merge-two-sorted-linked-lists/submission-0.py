# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

from itertools import chain


def traverse(node: Optional[ListNode]) -> Generator[ListNode]:
    while node:
        yield node
        node = node.next


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        nodes = sorted(
            chain(traverse(list1), traverse(list2)),
            key=lambda node: node.val
        )

        if not nodes:
            return None

        for i in range(len(nodes) - 1):
            nodes[i].next = nodes[i + 1]

        nodes[-1].next = None

        return nodes[0]
