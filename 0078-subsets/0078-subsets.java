class Solution {
    void helper(int[] nums, int idx,List<Integer> current, List<List<Integer>> ans ){
        if(idx == nums.length) {
            ans.add(new ArrayList<Integer>(current));
            return;
        }

        current.add(nums[idx]);
        //System.out.println(current);
        helper(nums, idx+1, current, ans);
        current.remove(current.size()-1);
        helper(nums, idx+1, current, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        helper(nums,0,current, ans);

        return ans;
    }
}