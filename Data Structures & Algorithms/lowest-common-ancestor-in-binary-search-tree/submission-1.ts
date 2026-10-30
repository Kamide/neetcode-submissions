type TN = { val: number; left: TNM; right: TNM };
type TNM = TN | null;

class Solution {
    lowestCommonAncestor(root: TNM, p: TNM, q: TNM): TNM {
        return (function dfs(node: TNM): TNM {
            if (node == null) {
                return null;
            }

            if (node === p || node === q) {
                return node;
            }

            const left = dfs(node.left);
            const right = dfs(node.right);

            if (left != null && right != null) {
                return node;
            }

            return left ?? right;
        })(root);
    }
}
