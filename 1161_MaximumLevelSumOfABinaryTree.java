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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int ret = 0, level = 1, size;
        int max = Integer.MIN_VALUE;
        int sum;
        q.add(root);
        TreeNode temp;
        while (!q.isEmpty()) {
            size = q.size();
            sum = 0;
            while (size-- > 0) {
                temp = q.poll();
                sum += temp.val;
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            if (sum > max) {
                max = sum;
                ret = level;
            }
            level++;
        }
        return ret;
    }
}
