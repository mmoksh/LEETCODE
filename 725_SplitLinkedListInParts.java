/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] list = new ListNode[k];
        int size = getSize(root);
        double partSize = size * 1.0 / k;
        int bigSize = (int) Math.ceil(partSize);
        int smallSize = (int) Math.floor(partSize);
        int kBig = size - smallSize * k;
        ListNode temp = null;
        for (int i = 0; i < kBig; i++) {
            list[i] = root;
            for (int j = 0; j < bigSize; j++) {
                temp = root;
                root = root.next;
            }
            if (temp != null) {
                temp.next = null;
            }
        }
        for (int i = kBig; i < k; i++) {
            list[i] = root;
            for (int j = 0; j < smallSize; j++) {
                temp = root;
                root = root.next;
            }
            if (temp != null) {
                temp.next = null;
            }
        }
        return list;
    }
    
    public int getSize(ListNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.next;
        }
        return count;
    }
}
