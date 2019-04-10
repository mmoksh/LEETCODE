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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int max, size;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode temp;
        while (!q.isEmpty()) {
            max = q.peek().val;
            size = q.size();
            for (int i = 0; i < size; i++) {
                temp = q.poll();
                max = Math.max(max, temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
