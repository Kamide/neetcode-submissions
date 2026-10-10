class Solution {
  diameterOfBinaryTree(root: TreeNode | null): number {
    let diameter = 0;

    (function maxDepth(node: TreeNode | null): number {
      if (node == null) {
        return 0;
      }

      const leftDepth = maxDepth(node.left);
      const rightDepth = maxDepth(node.right);

      diameter = Math.max(diameter, leftDepth + rightDepth);

      return 1 + Math.max(leftDepth, rightDepth);
    })(root);

    return diameter;
  }
}
