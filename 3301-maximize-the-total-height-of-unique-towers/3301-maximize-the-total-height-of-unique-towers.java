class Solution {
    public long maximumTotalSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int cur_min = nums[n-1];
        long ans = 0;
        for(int i = n-1;i>=0;i--){
            if(nums[i]<cur_min){
                cur_min = nums[i];
                ans+=cur_min;
                cur_min-=1;
            }
            else{
                ans+=cur_min;
                cur_min-=1;
            }

            if(cur_min==0 && i>0){
                return -1;
            }
        }

        return ans;
    }
}