
class Solution {
    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result);
        return result;
    }

    private static void backtrack(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            Collections.swap(nums, start, i);
            backtrack(nums, start + 1, result);
            Collections.swap(nums, start, i); // backtrack
        }
    }

    public int findMinimumTime(List<Integer> strength, int k) {

        int min_t = Integer.MAX_VALUE;
        List<List<Integer>> perms = permute(strength);
        for (List<Integer> perm : perms) {
            int t = 1;
            int x = 1;
            int idx = 0;
            int energy = 1;

            while (idx < perm.size()) {
                if (perm.get(idx) <= energy) {
                    x += k;
                    energy = x;
                    idx++;
                    if (idx == strength.size()) {
                        min_t = Math.min(min_t, t);
                    }
                    t++;
                } else {
                    energy += x;
                    t++;
                }
            }
            min_t = Math.min(min_t, t);
        }
        return min_t;
    }
}