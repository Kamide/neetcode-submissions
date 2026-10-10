type TN = {
    val: number;
    left: TN | null;
    right: TN | null;
};

const invert = (root: TN | null): TN | null => {
    if (root == null) {
        return null;
    }

    [root.left, root.right] = [root.right, root.left];

    invert(root.left);
    invert(root.right);

    return root;
};

class Solution {
    invertTree(root: TN | null): TN | null {
        return invert(root);
    }
}
