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
    def removeNthFromEnd(self, head: ListNode | None, n: int) -> ListNode | None:
        nodes = list(traverse(head))
        del nodes[len(nodes) - n]
        relink(nodes)
        return nodes[0] if nodes else None
