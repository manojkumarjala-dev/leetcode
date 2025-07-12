class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long[][] minmax = new long[n][2];

        minmax[n - 1][0] = nums[n - 1];  // min
        minmax[n - 1][1] = nums[n - 1];  // max

        long result = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            long v1 = (long) nums[i] * minmax[i + 1][0];
            long v2 = (long) nums[i] * minmax[i + 1][1];

            minmax[i][0] = Math.min(nums[i], Math.min(v1, v2));
            minmax[i][1] = Math.max(nums[i], Math.max(v1, v2));

            result = Math.max(result, minmax[i][1]);
        }

        return (int) result;
    }
}
