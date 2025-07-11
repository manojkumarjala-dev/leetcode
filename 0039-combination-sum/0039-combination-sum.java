class Solution {
    void helper(int[] candidates, int idx, List<Integer> current, List<List<Integer>> ans, int target, int cur_sum){
        if(cur_sum==target){
            ans.add(new ArrayList<Integer>(current));
            return;
        }
        
        for(int i = idx;i<candidates.length;i++){
            if(cur_sum+candidates[i]>target) continue;
            current.add(candidates[i]);
            helper(candidates, i , current, ans, target, cur_sum+candidates[i]);
            current.remove(current.size()-1);
        }

    }   
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        helper(candidates, 0, current, ans, target, 0);

        return ans;
    }
}