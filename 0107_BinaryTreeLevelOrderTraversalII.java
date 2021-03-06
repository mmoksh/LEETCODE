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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp;
        int currentSize;
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> levelList = new LinkedList();
            currentSize = q.size();
            for (int i = 0; i < currentSize; i++) {
                temp = q.poll();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                levelList.add(temp.val);
            }
            list.add(0, levelList);
        }
        return list;
    }
}
