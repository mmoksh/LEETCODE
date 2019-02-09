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
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        
        }
        if (root.left == null && root.right == null) {
            return String.valueOf((char)(root.val + 'a'));
        }
        
        if (root.left != null && root.right != null) {
            String left = smallestFromLeaf(root.left);
            String right = smallestFromLeaf(root.right);
            if (left.compareTo(right) <= 0) {
                return left + (char) (root.val + 'a');
            } else {
                return right + (char) (root.val + 'a');
            }
        }
        
        if (root.left == null) {
            return smallestFromLeaf(root.right) + (char) (root.val + 'a');
        }
        
        return smallestFromLeaf(root.left) + (char) (root.val + 'a');
    }
}
