# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


def traverse(node: Optional[TreeNode]) -> Generator[int | None]:
    if node is None:
        yield None
        return

    yield node.val
    yield from traverse(node.left)
    yield from traverse(node.right)


def serialize(iterable: Iterable[int | None]) -> str:
    return " ".join("_" if val is None else str(val) for val in iterable)


class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        return serialize(traverse(subRoot)) in serialize(traverse(root))
