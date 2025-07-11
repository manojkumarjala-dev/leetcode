class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        
        q.offer(node);
        map.put(node, new Node(node.val));  // Make sure to clone the starting node

        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();

                if (cur.neighbors != null) {
                    for (Node n : cur.neighbors) {
                        if (!map.containsKey(n)) {
                            map.put(n, new Node(n.val));  // Clone the neighbor
                            q.offer(n);                   // Add the neighbor for future processing
                        }
                    }
                }
            }
        }

        q.offer(node);
        Set<Node> visited = new HashSet<>();
        
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                Node cur = q.poll();
                if (visited.contains(cur)) continue;
                visited.add(cur);

                Node copy = map.get(cur);

                if (cur.neighbors != null) {
                    for (Node n : cur.neighbors) {
                        copy.neighbors.add(map.get(n));
                        q.offer(n);
                    }
                }
            }
        }

        return map.get(node);
    }
}
