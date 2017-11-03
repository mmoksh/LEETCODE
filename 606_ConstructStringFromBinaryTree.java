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
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if ("".equals(left) && "".equals(right)) {
            return "" + t.val;
        } else if ("".equals(right)) {
            return t.val + "(" + left + ")";
        } else if ("".equals(left)) {
            return t.val + "()(" + right + ")";
        } else {
            return t.val + "(" + left + ")(" + right + ")";
        }
    }
}
