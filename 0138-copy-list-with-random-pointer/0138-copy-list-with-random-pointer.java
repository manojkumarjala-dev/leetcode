/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Map<Node,Node> map = new HashMap<>();

        if(head==null){
            return null;
        }

        while(temp!=null){
            Node node2 = new Node(temp.val);
            map.put(temp,node2);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            Node node1 = map.get(temp);
            if(temp.next!=null){
                Node node2 = map.get(temp.next);
                node1.next = node2;
            }
            if(temp.random!=null){
                Node node2 = map.get(temp.random);
                node1.random = node2;
            }
            temp = temp.next;
        }

        return map.get(head);
        
    }
}