from itertools import zip_longest
from typing import Generator, Iterable


def traverse(node: ListNode | None) -> Generator[ListNode, None, None]:
    while node:
        yield node
        node = node.next


def values(nodes: Iterable[ListNode]) -> Generator[int, None, None]:
    for node in nodes:
        yield node.val


def relink(nodes: list[ListNode]) -> ListNode | None:
    if not nodes:
        return None

    for i in range(len(nodes) - 1):
        nodes[i].next = nodes[i + 1]

    nodes[-1].next = None

    return nodes[0]


class Solution:
    def addTwoNumbers(self, l1: ListNode | None, l2: ListNode | None) -> ListNode | None:
        lefts = list(values(traverse(l1)))
        rights = list(values(traverse(l2)))

        sum_nodes: list[ListNode] = []
        carry = 0

        for left, right in zip_longest(lefts, rights, fillvalue=0):
            sum_ = left + right + carry
            sum_nodes.append(ListNode(sum_ % 10))
            carry = sum_ // 10

        if carry:
            sum_nodes.append(ListNode(carry))

        return relink(sum_nodes)
