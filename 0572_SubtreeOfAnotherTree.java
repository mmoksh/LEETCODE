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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return s == t;
        if (checkSubtree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean checkSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return s == t;
        return s.val == t.val && checkSubtree(s.left, t.left) && checkSubtree(s.right, t.right);
    }
}
