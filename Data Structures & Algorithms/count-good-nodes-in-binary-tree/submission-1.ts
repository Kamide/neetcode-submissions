type TN = { val: number; left: TNM; right: TNM };
type TNM = TN | null;

class Solution {
    goodNodes(root: TNM): number {
        return (function dfs(node: TNM, max: number): number {
            if (node == null) {
                return 0;
            }

            const count = node.val >= max ? 1 : 0;

            max = Math.max(max, node.val);

            return count + dfs(node.left, max) + dfs(node.right, max);
        })(root, -Infinity);
    }
}
