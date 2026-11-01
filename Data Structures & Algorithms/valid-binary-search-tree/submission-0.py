class Solution:
    def isValidBST(self, root: TreeNode | None) -> bool:
        def dfs(node: TreeNode | None, min_val: int | float, max_val: int | float) -> bool:
            if node is None:
                return True

            if node.val <= min_val or node.val >= max_val:
                return False

            return dfs(node.left, min_val, node.val) and dfs(node.right, node.val, max_val)

        return dfs(root, float("-inf"), float("inf"))
