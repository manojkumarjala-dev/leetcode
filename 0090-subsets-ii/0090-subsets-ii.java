class Solution {
    // wacth neetcode subsetrs 2 video fro reference
    // core idea is instead of thinkin take and not take 
    // consider if i take a value then all the children must include what is there

    // if i dont take a node then i should skip all the nodes which have same value as the node i just skipped
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