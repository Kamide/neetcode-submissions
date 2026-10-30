type TN = { val: number; left: TNM; right: TNM };
type TNM = TN | null;

class Solution {
    rightSideView(root: TNM): number[] {
        const visible: number[] = [];

        (function dfs(node: TNM, depth: number) {
            if (node == null) {
                return;
            }

            visible[depth] = node.val;

            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        })(root, 0);

        return visible;
    }
}
