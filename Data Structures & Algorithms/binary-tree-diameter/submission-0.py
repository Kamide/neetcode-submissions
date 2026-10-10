# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from functools import cache


@cache
def max_depth_of(node: Optional[TreeNode]) -> int:
    if node is None:
        return 0

    left_depth = max_depth_of(node.left)
    right_depth = max_depth_of(node.right)
    return 1 + max(left_depth, right_depth)


def max_diameter_of(node: Optional[TreeNode]) -> int:
    if node is None:
        return 0

    left_depth = max_depth_of(node.left)
    right_depth = max_depth_of(node.right)
    diameter_through_node = left_depth + right_depth

    return max(
        diameter_through_node,
        max_diameter_of(node.left),
        max_diameter_of(node.right),
    )


class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        return max_diameter_of(root)
