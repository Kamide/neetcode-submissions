class Solution:
    def maxPathSum(self, root: TreeNode | None) -> int | float:
        max_path_sum = float("-inf")

        def path_sum(node: TreeNode | None) -> int:
            nonlocal max_path_sum

            if not node:
                return 0

            left_path_sum = max(0, path_sum(node.left))
            right_path_sum = max(0, path_sum(node.right))

            max_path_sum = max(max_path_sum, node.val + left_path_sum + right_path_sum)

            return node.val + max(left_path_sum, right_path_sum)

        path_sum(root)

        return max_path_sum
