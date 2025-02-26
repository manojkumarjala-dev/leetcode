class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int curSum = 0, maxSum = 0 ; boolean signChange = false;
        boolean prevN = false, prevP = false;
        for(int i = 0;i<nums.length;i++){

            if(curSum>0 && curSum+nums[i]<=0){
                signChange = true;
                prevN = true;
            }
            if(curSum<0 && curSum+nums[i]>=0){
                signChange = true;
                prevP = true;
            }
            curSum+=nums[i];

            if(signChange){
                if(curSum<0){
                    curSum -= maxSum;
                    maxSum = Math.abs(curSum);
                    signChange = false; 
                }
                else if(curSum>0) {
                    curSum += maxSum;
                    maxSum = Math.abs(curSum);
                    signChange = false; 
                }
                else{
                    if(prevP){
                        curSum = maxSum;
                    }
                    else{
                        curSum = 0-maxSum;
                    }
                    prevN = false;prevP = false;
                    signChange = false;
                }
            }
            maxSum = Math.max(Math.abs(curSum),maxSum);

            //System.out.println("curSum "+curSum+" maxSum:"+maxSum);
        }


        return maxSum;
    }
}