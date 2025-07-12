class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        int n = nums.length;
        for(int num:nums) total+=num;

        int sum = (total+target)/2;

        if (total < Math.abs(target) || (total + target) % 2 != 0) return 0;


        int[][] dp = new int[n+1][sum+1];

        // 0 sum 
        dp[0][0] = 1;


        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=sum;j++){
                // if possible to add the count number of possibilities to include & exclude
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }
                else{
                // since value is more than what we need copy the same sum exluding the ith index
                    dp[i][j] = dp[i-1][j];
                }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }

        return dp[n][sum];
    }
}