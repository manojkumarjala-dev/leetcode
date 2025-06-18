class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[][] result = new long[k][nums.length];
        result[nums[0]%k][0]++;

        for (int i = 1; i < nums.length; i++) {
            for(int j=0;j<k;j++){
                if(result[j][i-1]==0) continue;
                result[((j%k)*(nums[i]%k))%k][i]+=result[j][i-1];
            }    
            result[nums[i]%k][i]++;
        }
        long[] ans = new long[k];
        for(int i = 0;i<k;i++){
            long sum = 0;
            for(int j = 0;j<nums.length;j++){
                sum+=result[i][j];
            }
            ans[i] = sum;
        }

        return ans;

        
    }
}