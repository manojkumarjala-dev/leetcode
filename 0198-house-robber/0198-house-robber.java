class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        
        int[] profit = new int[n];
        profit[n-1] = nums[n-1];
        profit[n-2] = Math.max(nums[n-1],nums[n-2]);


        for(int i = n-3;i>=0;i--){
            profit[i] = Math.max(nums[i]+profit[i+2], profit[i+1]);
        }

        return profit[0]; 
    }
}

















//old solution
        // int[] points = new int[nums.length];
        // points[nums.length - 1] = nums[nums.length - 1];
        // for (int i = nums.length - 2; i >= 0; i--) {
        //     points[i] = Math.max(points[i + 1], nums[i] + (i + 2 < nums.length ? points[i + 2] : 0));

        // }