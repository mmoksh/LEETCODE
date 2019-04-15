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
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff2(root)[0];
    }
    
    public int[] maxAncestorDiff2(TreeNode root) {
        if (root == null) {
            return new int[]{0, 5000, 0};
        }
        
        int[] left = maxAncestorDiff2(root.left);
        int[] right = maxAncestorDiff2(root.right);
        
        int min = Math.min(root.val, Math.min(left[1], right[1]));
        int max = Math.max(root.val, Math.max(left[2], right[2]));
        int result = Math.max(Math.max(left[0], right[0]), Math.max(root.val - min, max - root.val));
        return new int[]{result, min, max};
    }
}
