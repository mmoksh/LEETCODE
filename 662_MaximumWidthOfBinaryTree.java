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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> indexes = new LinkedList<>();
        q.add(root);
        indexes.add(1);
        TreeNode tempNode;
        int tempIndex;
        int min, max, maxDifference = 0;
        int size;
        while (!q.isEmpty()) {
            size = q.size();
            
            min = indexes.peek();
            max = indexes.peek();
            for (int i = 0; i < size; i++) {
                tempNode = q.poll();
                tempIndex = indexes.poll();
                
                if (tempIndex > max) max = tempIndex;
                else if (tempIndex < min) min = tempIndex;
                
                if (tempNode.left != null) {
                    q.add(tempNode.left);
                    indexes.add(tempIndex * 2);
                }
                
                if (tempNode.right != null) {
                    q.add(tempNode.right);
                    indexes.add(tempIndex * 2 + 1);
                }
            }
            maxDifference = Math.max(maxDifference, max - min);
        }
        return maxDifference + 1;
    }
}
