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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList();
        }

        List<List<Integer>> list = new LinkedList();

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp;

        int level = -1;

        q.add(null);
        q.add(root);

        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                    level++;
                    continue;
                }
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
            if (list.size() <= level) {
                list.add(new ArrayList<>());
            }
            if ((level & 1) == 0) {
                list.get(level).add(temp.val);
            } else {
                list.get(level).add(0, temp.val);
            }
        }
        return list;
    }
}
