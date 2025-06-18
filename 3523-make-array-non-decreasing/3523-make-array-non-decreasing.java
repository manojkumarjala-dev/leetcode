class Solution {
    public int maximumPossibleSize(int[] nums) {
        int i = 1;
        int total = 1;
        int val = nums[0];
        while(i<nums.length){
            if(val>nums[i]){
                i++;
            }
            else{
                val = nums[i];
                total++;
                i++;
            }
        }
        return total;
    }
}