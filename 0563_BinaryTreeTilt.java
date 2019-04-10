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
    int globalSum = 0;
    public int findTilt(TreeNode root) {
        calcTilt(root);
        return globalSum;
    }
    
    public int calcTilt(TreeNode root) {
        if (root == null) return 0;
        int leftSum = calcTilt(root.left);
        int rightSum = calcTilt(root.right);
        globalSum += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
