class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int i =0,j=2;
        int[][] ans = new int[nums.length/3][3];
        while(j<nums.length){
            if(nums[j]-nums[i]>k){
                return new int[0][0];
            }
            i+=3;j+=3;
        }


        for(int l =0;l<nums.length;l++){
            ans[l/3][l%3] = nums[l];
        }

        return ans;

    }
}