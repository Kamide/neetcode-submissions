class Solution:
    def goodNodes(self, root: TreeNode | None) -> int:
        def dfs(node: TreeNode | None, max_val: int | float) -> int:
            if node is None:
                return 0

            count = 0

            if node.val >= max_val:
                count += 1
                max_val = node.val

            count += dfs(node.left, max_val)
            count += dfs(node.right, max_val)

            return count

        return dfs(root, float("-inf"))
