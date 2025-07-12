class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];

        Arrays.fill(count,1);

        for(int i = n-2;i>=0;i--){
            for(int j = i+1;j<n;j++){
                if(nums[i]<nums[j]){
                    count[i] = Math.max(count[i], 1+count[j]);
                }
            }
        }

        int max = 0;
        for(int num: count){
            max = Math.max(max, num);
        }

        System.out.println(Arrays.toString(count));

        return max;
        
    }
}