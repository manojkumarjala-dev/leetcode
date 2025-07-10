/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        Stack<ListNode> pq = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            pq.push(temp);
            temp = temp.next;
        }

        temp = head;
        int size = pq.size();
        if (size > 2) {

            size = size / 2;

            while (size-- > 0) {
                ListNode next = temp.next;
                if (temp.next == pq.peek()) {
                    temp = temp.next;
                    break;
                }
                temp.next = pq.pop();
                temp = temp.next;
                temp.next = next;
                temp = temp.next;
            }
            temp.next = null;

        }

    }
}