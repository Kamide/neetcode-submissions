from itertools import batched, chain, zip_longest
from typing import Generator


def traverse(node: ListNode | None) -> Generator[ListNode, None, None]:
    while node:
        yield node
        node = node.next


def relink(nodes: list[ListNode]) -> ListNode | None:
    if not nodes:
        return None

    for node, next_node in zip_longest(nodes, nodes[1:]):
        node.next = next_node

    return nodes[0]


class Solution:
    def reverseKGroup(self, head: ListNode | None, k: int) -> ListNode | None:
        return relink(
            list(
                chain.from_iterable(
                    reversed(chunk) if len(chunk) == k else chunk
                    for chunk in batched(traverse(head), k)
                )
            )
        )
