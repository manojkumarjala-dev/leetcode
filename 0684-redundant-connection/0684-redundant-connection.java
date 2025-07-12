class Solution {
    class Node{
        int data;
        Node parent;
        int rank;
    }

    Node makeSet(int data){
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;

        return node;
    }

    Node findSet(Node node){
        if (node.parent != node) {
            node.parent = findSet(node.parent); 
        }
        return node.parent;
    }

    void union(Node a, Node b){
        Node asSet = findSet(a);
        Node bsSet = findSet(b);

        if(asSet!=bsSet){
            if(asSet.rank>bsSet.rank){
                bsSet.parent = asSet;
            }
            else if(asSet.rank<bsSet.rank){
                asSet.parent = bsSet;
            }
            else{
                bsSet.parent = asSet;
                asSet.rank = asSet.rank+1;                  
            }
        }  
    }


    public int[] findRedundantConnection(int[][] edges) {

        int n = 0;
        for(int[] edge: edges){
            n = Math.max(n, edge[0]);
            n = Math.max(n, edge[1]);
        } 
        n=n+1;
        Map<Integer, Node> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, makeSet(i));
        }

        for(int[] edge : edges){
            if(findSet(map.get(edge[0]))==findSet(map.get(edge[1]))) return edge;
            union(map.get(edge[0]),map.get(edge[1]));
        }

        return edges[0];
        
    }
}