class Solution {
    int[][] dp;
    int helper(int[] nums, int idx, int start){
        if(idx>=nums.length) return 0;
        if(dp[start][idx]!=-1) return dp[start][idx];
        if(start==0 && idx == nums.length-1) return 0;
        if(start==1 && idx == nums.length-1) return nums[nums.length-1];

        dp[start][idx] = Math.max(nums[idx] + helper(nums, idx+2, start), helper(nums, idx+1, start));
        return dp[start][idx];
    }
    public int rob(int[] nums) {

        dp = new int[2][nums.length];
        for(int[] d: dp){
            Arrays.fill(d,-1);
        }

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        return Math.max(helper(nums, 0, 0),helper(nums, 1, 1));

    }
}