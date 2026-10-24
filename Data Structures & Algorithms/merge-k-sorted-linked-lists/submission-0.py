from itertools import chain
from typing import Generator


def traverse(node: ListNode | None) -> Generator[ListNode, None, None]:
    while node:
        yield node
        node = node.next


def relink(nodes: list[ListNode]) -> ListNode | None:
    if not nodes:
        return None

    for i in range(len(nodes) - 1):
        nodes[i].next = nodes[i + 1]

    nodes[-1].next = None

    return nodes[0]


class Solution:
    def mergeKLists(self, lists: list[ListNode | None]) -> ListNode | None:
        return relink(
            sorted(
                chain.from_iterable(traverse(head) for head in lists),
                key=lambda node: node.val
            )
        )
