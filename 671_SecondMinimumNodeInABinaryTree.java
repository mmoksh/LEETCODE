/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        return rec(root, root.val);
    }
    
    public int rec(TreeNode root, int min) {
        if (root == null) {
            return -1;
        }
        int x = rec(root.left, min);
        int y = rec(root.right, min);
        int ret = -1;
        
        if (x > min) {
            ret = x;
        }
        
        if (y > min && (y < ret || ret == -1)) {
            ret = y;
        }
        if (root.val > min && (root.val < ret || ret == -1)) {
            ret = root.val;
        }
        return ret;
    }
}
