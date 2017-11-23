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
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calcDiameter(root);
        return max;
    }
    
    public int calcDiameter(TreeNode node) {
        if (node == null) return 0;
        int leftPathLong = calcDiameter(node.left);
        int rightPathLong = calcDiameter(node.right);
        max = Math.max(max, leftPathLong + rightPathLong);
        return Math.max(leftPathLong, rightPathLong) + 1;
    }
}
