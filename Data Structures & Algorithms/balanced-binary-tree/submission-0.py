# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

def balanced_height_maybe(node: Optional[TreeNode]) -> Optional[int]:
    if node is None:
        return 0

    left = balanced_height_maybe(node.left)
    if left is None:
        return None

    right = balanced_height_maybe(node.right)
    if right is None:
        return None

    if abs(left - right) > 1:
        return None

    return 1 + max(left, right)


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return balanced_height_maybe(root) is not None
