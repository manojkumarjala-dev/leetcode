class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        long[] dp = new long[n + 1]; // dp[i] = max sum starting at i with len % k == 0

        if (k == 1) {
            long maxSum = Long.MIN_VALUE;
            long currSum = 0;
            for (int num : nums) {
                currSum = Math.max(num, currSum + num);
                maxSum = Math.max(maxSum, currSum);
            }
            return maxSum;
        }

        // Step 1: build prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long max = Long.MIN_VALUE;

        // Step 2: fill dp from back to front
        for (int i = n - k; i >= 0; i--) {
            // sum of block [i, i + k - 1]
            long blockSum = prefix[i + k] - prefix[i];

            // Add future dp if available
            if (i + k <= n - k) {
                dp[i] = Math.max(blockSum,blockSum + dp[i + k]);
            } else {
                dp[i] = blockSum;
            }

            max = Math.max(max, dp[i]);
        }

        return max == Long.MIN_VALUE ? 0 : max;
    }
}
