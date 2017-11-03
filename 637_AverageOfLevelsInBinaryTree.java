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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        double sum = 0;
        int count = 0;
        q.add(root);
        q.add(null);
        TreeNode node;
        while (!q.isEmpty()) {
            node = q.poll();
            if (node == null) {
                ret.add(sum / count);
                sum = 0;
                count = 0;
                if (!q.isEmpty()) {
                    q.add(null);
                    continue;
                }
                break;
            }
            sum += node.val;
            count++;
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return ret;
    }
}
