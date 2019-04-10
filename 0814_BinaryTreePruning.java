/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static TreeNode pruneTree(TreeNode root) {
        if (pruneTree2(root) == 0) {
            return null;
        }
        return root;
    }

    public static int pruneTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = pruneTree2(root.left);
        int r = pruneTree2(root.right);
        if (l == 0) {
            root.left = null;
        }
        if (r == 0) {
            root.right = null;
        }
        return l + r + root.val;
    }
}
