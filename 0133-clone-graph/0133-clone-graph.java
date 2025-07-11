/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        q.offer(node);
        if(node==null) return null;

        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                Node cur = q.poll();
                if(!map.containsKey(cur)) map.put(cur, new Node(cur.val));
                
                if(cur.neighbors!=null){
                    List<Node> adj = cur.neighbors;
                    for(Node n: adj){
                        if(!map.containsKey(n)) q.offer(n);
                    }
                }
            }
        }

        q.offer(node);

        Set<Node> visited = new HashSet<>();
        q.offer(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (visited.contains(cur)) continue;
            visited.add(cur);

            Node copy = map.get(cur);
            for (Node n : cur.neighbors) {
                copy.neighbors.add(map.get(n));
                q.offer(n);  // Enqueue unvisited neighbors
            }
        }


        return map.get(node);
        
    }
}