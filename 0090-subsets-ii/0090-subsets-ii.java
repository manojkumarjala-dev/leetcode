class Solution {
    void helper(int[] nums, List<List<Integer>> ans, int idx, List<Integer> current){
        if(idx == nums.length){
            ans.add(new ArrayList<Integer>(current));
            return;
        }

        current.add(nums[idx]);
        helper(nums, ans, idx+1, current);
        current.remove(current.size()-1);

        while(idx+1<nums.length && nums[idx] == nums[idx+1]) idx++;
        idx++;
        helper(nums, ans, idx, current);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        helper(nums, ans, 0, new ArrayList<Integer>());

        return ans;
        
    }
}