class Solution {
    public int minTime(int n, int[][] edges) {
        int[] mTime = new int[n];
        Arrays.fill(mTime, Integer.MAX_VALUE);

        mTime[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0;i<n;i++) adj.add(new ArrayList<int[]>());

        for(int i = 0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];

            adj.get(src).add(new int[]{dest, edges[i][2], edges[i][3] });
        }



        pq.offer(new int[]{0,0});

        while(pq.size()>0){
            int[] shortest = pq.poll();

            int s = shortest[0];
            int cost = shortest[1];


            List<int[]> neighbours = adj.get(s);

            for(int[] neighbour:neighbours){

                int d = neighbour[0];
                int start_time = neighbour[1];
                int end_time = neighbour[2];


                if(cost>=mTime[d]) continue;

                if(cost<start_time){
                    if(mTime[d]>start_time+1){
                        mTime[d] = Math.min(mTime[d],start_time+1);
                        pq.offer(new int[]{ d, start_time+1});
                    }
                }
                else if( cost>=start_time && cost<=end_time){
                    if(mTime[d]>cost+1){
                        mTime[d] = Math.min(mTime[d],cost+1);
                        pq.offer(new int[]{ d, cost+1});
                    }   
                }
                else{
                    continue;
                }

            }

        }


        return mTime[n-1]!=Integer.MAX_VALUE?mTime[n-1]:-1;


        
        
    }
}