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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + (checkLeave(root.left)? root.left.val: 0);
    }
    
    public boolean checkLeave(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
