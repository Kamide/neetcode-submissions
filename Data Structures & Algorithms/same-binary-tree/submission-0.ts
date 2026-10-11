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

class Solution {
    /**
     * @param {TreeNode} p
     * @param {TreeNode} q
     * @return {boolean}
     */
    isSameTree(p: TreeNode | null, q: TreeNode | null): boolean {
        switch ((p ? 0b01 : 0b00) | (q ? 0b10 : 0b00)) {
            case 0b00:
                return true;
            case 0b01:
            case 0b10:
                return false;
            default:
                return (
                    p!.val === q!.val &&
                    this.isSameTree(p!.left, q!.left) &&
                    this.isSameTree(p!.right, q!.right)
                );
        }
    }
}
