type Tree = { val: number; left: TreeMaybe; right: TreeMaybe };
type TreeMaybe = Tree | null | undefined;

const equals = (a: TreeMaybe, b: TreeMaybe): boolean =>
    a === b ||
    (a != null &&
        b != null &&
        a.val === b.val &&
        equals(a.left, b.left) &&
        equals(a.right, b.right));

const contains = (haystack: TreeMaybe, needle: TreeMaybe): boolean =>
    needle == null ||
    (haystack != null &&
        (equals(haystack, needle) ||
            contains(haystack.left, needle) ||
            contains(haystack.right, needle)));

class Solution {
    isSubtree = (root: TreeMaybe, subRoot: TreeMaybe): boolean => contains(root, subRoot);
}
