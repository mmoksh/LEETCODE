/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static int numComponents(ListNode head, int[] G) {
        HashSet<Integer> hash = new HashSet<>();
        for (int num : G) {
            hash.add(num);
        }
        
        boolean connected = false;
        int connectedComponents = 0;
        while (head != null) {
            if (hash.contains(head.val)) {
                if (!connected) {
                    connected = true;
                    connectedComponents++;
                }
            } else {
                connected = false;
            }
            head = head.next;
        }
        
        return connectedComponents;
    }
}
