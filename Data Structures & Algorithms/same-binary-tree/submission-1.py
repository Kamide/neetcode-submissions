# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

def tree(p: Optional[TreeNode]):
    if p is None:
        return None

    return [p.val, tree(p.left), tree(p.right)]


class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        return tree(p) == tree(q)
