type TN = { val: number; left: TNM; right: TNM };
type TNM = TN | null;

class Solution {
    buildTree(preorder: number[], inorder: number[]): TNM {
        if (preorder.length === 0) {
            return null;
        }

        const inorderIndexByValue = new Map<number, number>();

        for (let index = 0; index < inorder.length; index++) {
            inorderIndexByValue.set(inorder[index], index);
        }

        let preorderIndex = 0;

        return (function build(left: number, right: number): TNM {
            if (left > right) {
                return null;
            }

            const value = preorder[preorderIndex];

            preorderIndex += 1;

            const inorderIndex = inorderIndexByValue.get(value)!;

            return {
                val: value,
                left: build(left, inorderIndex - 1),
                right: build(inorderIndex + 1, right),
            };
        })(0, inorder.length - 1);
    }
}
