class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length-k+1;

        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->b-a);

        for(int num : nums){
            if(pq.size()<k){
                pq.offer(num);
            }
            else{
                if(pq.peek()<=num) continue;
                else{
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        return pq.peek();
        
    }
}