"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""


def clone(original: Optional["Node"], original_to_clone: dict[Node, Node]):
    if original is None:
        return None

    if original in original_to_clone:
        return original_to_clone[original]

    copy = Node(original.val, None)
    original_to_clone[original] = copy
    copy.neighbors = [clone(node, original_to_clone) for node in original.neighbors]

    return copy


class Solution:
    def cloneGraph(self, node: Optional["Node"]) -> Optional["Node"]:
        return clone(node, {})
