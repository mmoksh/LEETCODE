/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int size = getSize(head);
        int index = size / 2;
        ListNode rev = head;
        while (index-- > 0) {
            rev = rev.next;
        }
        rev = reverseList(rev);
        index = size / 2;
        ListNode tmp = head;
        while (index-- > 0) {
            if (rev.val != tmp.val) {
                return false;
            }
            rev = rev.next;
            tmp = tmp.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        
        ListNode p = head, q = p.next, r = q.next;
        
        while (r != null) {
            q.next = p;
            
            p = q;
            q = r;
            r = r.next;
        }
        
        q.next = p;
        head.next = null;
        
        return q;
    }
    
    public int getSize(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
}
