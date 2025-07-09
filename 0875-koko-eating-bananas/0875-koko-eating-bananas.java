class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = piles[0], high = piles[0];

        for(int pile: piles){
            high = Math.max(high, pile);
        }
        low = 1;


        while(low<high){
            int mid = low + (high-low)/2;
            int hours = 0;

            for(int pile: piles){
                hours += (pile + mid - 1) / mid;
            }

            //System.out.println("For mid: "+mid+" hours takes are "+ hours);
            
            if(hours>h){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }

        return low;

        
    }
}