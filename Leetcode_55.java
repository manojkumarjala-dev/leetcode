public class Leetcode_55 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = 0;
            int[] ans = new int[nums.length];
            if(nums[0]>0){
                ans[0]=nums[0];
                max= Math.max(max,ans[0]);
            }
            else{
                ans[0] = nums[0];
                max= ans[0];
            }
            for(int i =1 ;i<nums.length;i++){
                if(ans[i-1]+nums[i]>=0){
                    ans[i] = Math.max(ans[i-1]+nums[i],Math.max(0,nums[i]));
                }
                else{
                    ans[i] = nums[i];
                }

                max = Math.max(max,ans[i]);
            }

            return max;
        }
    }
}
