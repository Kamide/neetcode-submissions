def copy(original: Node | None, original_to_clone: dict[Node, Node]) -> Node | None:
    if original is None:
        return None

    if original in original_to_clone:
        return original_to_clone[original]

    clone = Node(original.val)
    original_to_clone[original] = clone
    clone.next = copy(original.next, original_to_clone)
    clone.random = copy(original.random, original_to_clone)

    return clone


class Solution:
    def copyRandomList(self, head: Node | None) -> Node | None:
        return copy(head, {})
