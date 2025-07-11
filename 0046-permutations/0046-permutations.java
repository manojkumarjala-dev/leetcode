class Solution {
    public void helper(List<List<Integer>> ans, int[] nums, int cur){
        if(cur == nums.length){
            List < Integer > ds = new ArrayList < > ();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList < > (ds));
            return;
        }
        for(int i = cur; i<nums.length; i++){
            int temp = nums[cur];
            nums[cur] = nums[i];
            nums[i] = temp;


            helper(ans, nums, cur+1);
            
            temp = nums[cur];
            nums[cur] = nums[i];
            nums[i] = temp;

            

        }
    }
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();


        helper(ans, nums, 0);


        return ans;

        
    }
}