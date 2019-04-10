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
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }
    
    public int sumRootToLeaf(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        num = num * 2 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        return sumRootToLeaf(root.left, num) + sumRootToLeaf(root.right, num);
    }
}
