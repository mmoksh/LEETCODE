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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        } else {
            DFS(root, v, d, 1);
            return root;
        }
    }
    
    public void DFS(TreeNode root, int v, int d, int currentDepth) {
        if (root == null) {
            return;
        }
        if (currentDepth == d - 1) {
            TreeNode leftNode = new TreeNode(v);
            leftNode.left = root.left;
            root.left = leftNode;
            TreeNode rightNode = new TreeNode(v);
            rightNode.right = root.right;
            root.right = rightNode;
            return;
        }
        DFS(root.left, v, d, currentDepth + 1);
        DFS(root.right, v, d, currentDepth + 1);
    }
}
