class Solution {
    public int findMin(int[] nums) {

        int low = 0, high = nums.length-1;
        if(nums.length==2){
            return Math.min(nums[0],nums[1]);
        }

        while(low<high){
            int mid = low+ (high-low)/2;
            if(nums[low]<nums[mid] && nums[mid]<nums[high]) return nums[low];

            if(nums[low]<=nums[mid] && nums[high]<nums[mid]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }

        return nums[low];
        
    }
}