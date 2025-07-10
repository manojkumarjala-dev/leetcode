class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);

        for(int num: stones) pq.offer(num);

        while(pq.size()>=2){
            int x = pq.poll();
            int y = pq.poll();

            if(x==y) continue;
            else{
                pq.offer(Math.abs(x-y));
            }
        }

        return pq.size()==1?pq.poll():0;
        
    }
}