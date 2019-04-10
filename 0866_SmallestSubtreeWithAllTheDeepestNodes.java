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
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        return (TreeNode) subtreeWithAllDeepest(root, 0)[1];
    }
    
    public static Object[] subtreeWithAllDeepest(TreeNode root, int depth) {
        if (root == null) {
            return new Object[] {depth, null};
        }
        
        Object [] left = subtreeWithAllDeepest(root.left, depth + 1);
        Object [] right = subtreeWithAllDeepest(root.right, depth + 1);
        
        int leftDepth = (int) left[0];
        int rightDepth = (int) right[0];
        
        if (leftDepth == rightDepth) {
            return new Object[] {leftDepth, root};
        } else if (leftDepth > rightDepth) {
            return left;
        } else {
            return right;
        }
    }
}
