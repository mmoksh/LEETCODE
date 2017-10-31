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
    int max = 1;
    public int longestUnivaluePath(TreeNode root) {
        rec(root);
        return max - 1;
    }
    
    public int rec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftPathLength = rec(root.left);
        int rightPathLength = rec(root.right);
        
        int leftValue = root.left == null? -1:root.left.val;
        int rightValue = root.right == null? -1:root.right.val;
        
        int localMax = 1;
        
        if (leftValue == root.val) {
            localMax += leftPathLength;
        }
        
        if (rightValue == root.val) {
            localMax += rightPathLength;
        }
        
        this.max = Math.max(this.max, localMax);
        
        localMax = 1;
        
        if (leftValue == root.val) {
            localMax += leftPathLength;
        }
        
        if (rightValue == root.val) {
            localMax = Math.max(localMax, 1 + rightPathLength);
        }
        
        return localMax;
    }
}
