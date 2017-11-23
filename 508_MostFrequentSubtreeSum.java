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
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        postOrderTraversal(root, sums);
        int maxCount = 0, count = 0;
        for (Map.Entry<Integer, Integer> entry: sums.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                count = 1;
            } else if (entry.getValue() == maxCount) {
                count++;
            }
        }
        int [] ret = new int[count];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry: sums.entrySet()) {
            if (entry.getValue() == maxCount) {
                ret[index++] = entry.getKey();
            }
        }
        return ret;
    }
    
    public int postOrderTraversal(TreeNode root, HashMap<Integer, Integer> sums) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + postOrderTraversal(root.left, sums) + postOrderTraversal(root.right, sums);
        sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
