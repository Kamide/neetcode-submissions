/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

const unbalanced = Symbol("unbalanced");

const balancedHeightOf = (node: TreeNode | null): number => {
    if (node == null) {
        return 0;
    }

    const left = balancedHeightOf(node.left);
    const right = balancedHeightOf(node.right);

    if (Math.abs(left - right) > 1) {
        throw unbalanced;
    }

    return 1 + Math.max(left, right);
};

class Solution {
    /**
     * @param {TreeNode} root
     * @return {boolean}
     */
    isBalanced(root: TreeNode | null): boolean {
        try {
            balancedHeightOf(root);
            return true;
        } catch (error) {
            if (error === unbalanced) {
                return false;
            }
            throw error;
        }
    }
}
