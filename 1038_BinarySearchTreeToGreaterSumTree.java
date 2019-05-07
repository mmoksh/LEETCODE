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
    public TreeNode bstToGst(TreeNode root) {
        bstToGst(root, 0);
        return root;
    }
    
    public int bstToGst(TreeNode root, int val) {
        if (root == null) return val;
        int right = bstToGst(root.right, val);
        root.val += right;
        int left = bstToGst(root.left, root.val);
        return left;
    }
}
