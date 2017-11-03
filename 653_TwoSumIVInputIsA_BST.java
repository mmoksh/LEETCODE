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
    public boolean findTarget(TreeNode root, int k) {
        return findTwoTargets(root, k, root);
    }
    
    public boolean findTwoTargets(TreeNode root, int k, TreeNode originalRoot) {
        if (root == null) {
            return false;
        }
        
        if (findOneTarget(originalRoot, k - root.val, root)) {
            return true;
        }
        
        return findTwoTargets(root.left, k, originalRoot) || findTwoTargets(root.right, k, originalRoot);
    }
    
    public boolean findOneTarget(TreeNode root, int k, TreeNode searchNode) {
        if (root == null) {
            return false;
        }
        if (root != searchNode && root.val == k) {
            return true;
        }
        if (root.val > k) {
            return findOneTarget(root.left, k, searchNode);
        }
        return findOneTarget(root.right, k, searchNode);
    }
}
