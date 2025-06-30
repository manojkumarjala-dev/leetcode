class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max = 0;
        int totalKs = 0;

        for(int num:nums){
            if(num==k) totalKs++;
        }

        for(int i = 1;i<=50;i++){
            if(i==k) continue;
            int freq = 0;
            int ks = 0;
            int j = 0;
            int start = 0;

            while(j<nums.length){
                if(nums[j]==i){
                    freq++;
                }
                else if(nums[j]==k){
                    ks++;
                }

                if(freq-ks<=0){
                    freq = 0;ks = 0;
                    start = j+1;
                }
                else{
                    max = Math.max(max, totalKs +(freq-ks));
                    //System.out.println(max+" at i:"+i+", j:"+j+", start:"+start);
                }
                j++;
            }
        }


        return Math.max(max,totalKs);
        
    }
}