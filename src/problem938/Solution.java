package problem938;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int result = 0;
        if (L <= root.val && root.val <= R) {
            result += root.val;
        }
        if (root.left != null && L <= root.val)
            result += rangeSumBST(root.left, L, R);
        if (root.right != null && root.val <= R)
            result += rangeSumBST(root.right, L, R);
        return result;

    }
}