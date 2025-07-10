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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(4,null);

        ListNode temp = head;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val-b.val);

        for(int i = 0;i<lists.length;i++){
            if(lists[i]!=null) pq.offer(lists[i]);
        }

        while(pq.size()>0){
            ListNode smallest = pq.poll();
            if(smallest.next!=null) pq.offer(smallest.next);

            temp.next = smallest;
            temp = temp.next;
        }

        return head.next;


        
    }
}