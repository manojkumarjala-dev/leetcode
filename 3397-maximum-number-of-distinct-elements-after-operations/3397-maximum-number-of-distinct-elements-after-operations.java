class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0]-k+1;
        int ans = 1;
        for(int i=1;i<nums.length;i++){
            int val = nums[i]-min;
            if(val<=k && val>=(-1*k)){
                min++;
                ans++;
            }
            else if(min<nums[i]-k){
                ans++;
                min = nums[i]-k+1;
            }
            else{
                continue;
            }
        }

        return ans;
        
    }
}