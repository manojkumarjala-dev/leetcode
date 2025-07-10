/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head, fast = head;

        while(true){
            if(fast == null ) return false;
            if(fast.next == null || fast.next.next == null) return false;
            if(slow == null || slow.next == null ) return false;

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
    }
}