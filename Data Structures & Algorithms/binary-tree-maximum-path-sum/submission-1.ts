type TN = { val: number; left: TNM; right: TNM };
type TNM = TN | null;

class Solution {
    maxPathSum(root: TNM): number {
        let maxPathSum = -Infinity;

        (function pathSum(node: TNM): number {
            if (node == null) {
                return 0;
            }

            const leftPathSum = Math.max(0, pathSum(node.left));
            const rightPathSum = Math.max(0, pathSum(node.right));

            maxPathSum = Math.max(maxPathSum, node.val + leftPathSum + rightPathSum);

            return node.val + Math.max(leftPathSum, rightPathSum);
        })(root);

        return maxPathSum;
    }
}
