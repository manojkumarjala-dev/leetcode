class Solution {
    public int assignEdgeWeights(int[][] edges) {
        /*
        length = 2
        1,2
        _ : 1
        _ _ : 1,2 or 2,1
        _ _ _ : 1,1,1 or 1,2,2 or 2,2,1 or 2,1,2 == 1 f(n=2)even + 2 f(n=2)odd
        */
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length+1;
        int MOD = 1000000007;
        for(int i =0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i =0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] visited = new int[n+1];
        visited[1]=1;

        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        int depth = -1;
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                int node = q.poll();
                List<Integer> neighs = adj.get(node);
                for(int nei: neighs){
                    if(visited[nei]==1) continue;

                    visited[nei] = 1;
                    q.offer(nei);
                }
            }
            depth++;
        }

        int[] oddSum = new int[depth+1];
        int[] evenSum = new int[depth+1];

        oddSum[1]=1;
        evenSum[1]=1;


        for(int i = 2;i<=depth;i++){
            oddSum[i] = (evenSum[i-1]+oddSum[i-1])%MOD;
            evenSum[i] = (evenSum[i-1]+oddSum[i-1])%MOD;
        }

        return oddSum[depth];

    

    }
}