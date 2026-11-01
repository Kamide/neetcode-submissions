type TN = { val: number; left: TNM; right: TNM };
type TNM = TN | null;

class Solution {
    isValidBST(root: TNM): boolean {
        return (function dfs(node: TNM, min: number, max: number): boolean {
            if (node == null) {
                return true;
            }

            if (node.val <= min || node.val >= max) {
                return false;
            }

            return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
        })(root, -Infinity, Infinity);
    }
}
