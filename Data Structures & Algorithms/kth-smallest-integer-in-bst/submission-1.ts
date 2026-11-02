type TN = { val: number; left: TNM; right: TNM };
type TNM = TN | null;

class Solution {
    kthSmallest(root: TNM, k: number): number {
        return (function dfs(node: TNM): number | undefined {
            if (node == null) {
                return;
            }

            const left = dfs(node.left);

            if (left != null) {
                return left;
            }

            if (k === 1) {
                return node.val;
            }

            k -= 1;

            return dfs(node.right);
        })(root)!;
    }
}
