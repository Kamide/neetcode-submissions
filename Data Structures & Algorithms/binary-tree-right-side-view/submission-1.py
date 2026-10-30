class Solution:
    def rightSideView(self, root: TreeNode | None) -> list[int]:
        visible: list[int] = []

        def dfs(node: TreeNode | None, depth: int) -> None:
            if not node:
                return

            if depth == len(visible):
                visible.append(node.val)
            else:
                visible[depth] = node.val

            dfs(node.left, depth + 1)
            dfs(node.right, depth + 1)

        dfs(root, 0)

        return visible
