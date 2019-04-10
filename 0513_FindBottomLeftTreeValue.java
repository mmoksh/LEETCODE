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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp;
        int size, leftMostValue = 0;
        q.add(root);
        while (!q.isEmpty()) {
            leftMostValue = q.peek().val;
            size = q.size();
            for (int i = 0; i < size; i++) {
                temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return leftMostValue;
    }
}
