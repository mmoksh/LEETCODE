/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode last = ret;
        int ten = 0, temp;
        while (l1 != null && l2 != null) {
            temp = l1.val + l2.val + ten;
            last.next = new ListNode(temp % 10);
            last = last.next;
            ten = temp / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (ten == 0) {
                last.next = l1;
                break;
            }
            temp = l1.val + ten;
            last.next = new ListNode(temp % 10);
            last = last.next;
            ten = temp / 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            if (ten == 0) {
                last.next = l2;
                break;
            }
            temp = l2.val + ten;
            last.next = new ListNode(temp % 10);
            last = last.next;
            ten = temp / 10;
            l2 = l2.next;
        }
        if (ten == 1) {
            last.next = new ListNode(1);
        }
        return ret.next;
    }
}
