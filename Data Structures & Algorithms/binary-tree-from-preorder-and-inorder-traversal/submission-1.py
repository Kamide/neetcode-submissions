class Solution:
    def buildTree(self, preorder: list[int], inorder: list[int]) -> TreeNode | None:
        if not preorder:
            return None

        inorder_index_by_value = {
            value: i
            for i, value in enumerate(inorder)
        }

        preorder_index = 0

        def build(left: int, right: int) -> TreeNode | None:
            nonlocal preorder_index

            if left > right:
                return None

            value = preorder[preorder_index]
            preorder_index += 1
            inorder_index = inorder_index_by_value[value]

            return TreeNode(
                value,
                build(left, inorder_index - 1),
                build(inorder_index + 1, right),
            )

        return build(0, len(inorder) - 1)
