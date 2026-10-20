from typing import Generator


def traverse(node: ListNode | None) -> Generator[ListNode, None, None]:
    while node:
        yield node
        node = node.next


def relink(nodes: list[ListNode]) -> None:
    for i in range(len(nodes) - 1):
        nodes[i].next = nodes[i + 1]

    if nodes:
        nodes[-1].next = None


class Solution:
    def reorderList(self, head: ListNode | None) -> None:
        original = list(traverse(head))
        reordered: list[ListNode] = []

        left = 0
        right = len(original) - 1

        while left <= right:
            reordered.append(original[left])
            left += 1

            if left <= right:
                reordered.append(original[right])
                right -= 1

        relink(reordered)
