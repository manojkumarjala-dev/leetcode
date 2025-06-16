class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int n = nums.length;
        int max = nums[n-1];
        for(int i =1;i<n;i++){
            if(max - nums[n-i-1]>0){
                ans = Math.max(ans, max - nums[n-i-1]);
            }
            max = Math.max(max, nums[n-i-1]);
        }

        return ans;
        
    }
}