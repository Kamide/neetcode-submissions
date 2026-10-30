type TN = { val: number; left: TNM; right: TNM };
type TNM = TN | null;

class Solution {
    levelOrder(root: TNM): number[][] {
        const levels: number[][] = [];

        (function dfs(node: TNM, depth: number) {
            if (node == null) {
                return;
            }

            (levels[depth] ??= []).push(node.val);

            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        })(root, 0);

        return levels;
    }
}
