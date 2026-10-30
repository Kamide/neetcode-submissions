class Solution:
    def levelOrder(self, root: TreeNode | None) -> list[list[int]]:
        levels: list[list[int]] = []

        def dfs(node: TreeNode | None, depth: int) -> None:
            if not node:
                return

            if depth == len(levels):
                levels.append([])

            levels[depth].append(node.val)

            dfs(node.left, depth + 1)
            dfs(node.right, depth + 1)

        dfs(root, 0)

        return levels
