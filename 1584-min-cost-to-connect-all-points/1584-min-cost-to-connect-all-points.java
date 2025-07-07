class Solution {
    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        Set<Integer> set = new HashSet<>();
        int newly_added = 0;
        set.add(0);
        int ans = 0;

        while(set.size()<points.length){
            int[] point = points[newly_added];
            for(int i = 0;i<points.length;i++){
                if(set.contains(i)) continue;
                else{
                    int dist = Math.abs(point[0]-points[i][0])+ Math.abs(point[1]-points[i][1]);
                    pq.add(new int[] {dist, newly_added, i});
                }
            }

             while(pq.size()>0){
                int[] line = pq.poll();
                if(set.contains(line[1])&& set.contains(line[2])) continue;
                if(set.contains(line[1])){
                    set.add(line[2]);
                    newly_added = line[2];
                    ans+=line[0];
                    break;
                }
                if(set.contains(line[2])){
                    set.add(line[1]);
                    newly_added = line[1];
                    ans+=line[0];
                    break;
                }
            }
            if(set.size() == points.length){
                return ans;
            }

        }





        return ans;



        


        
    }
}