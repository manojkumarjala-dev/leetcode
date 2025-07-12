class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[] dp = new Integer[n];  
        return helper(prices, 0, dp);
    }

    int helper(int[] prices, int day, Integer[] dp) {
        if (day >= prices.length) return 0;

        if (dp[day] != null) return dp[day];

        int maxProfit = 0;

        for (int sell = day + 1; sell < prices.length; sell++) {
            if (prices[sell] > prices[day]) {
                int profit = prices[sell] - prices[day] + helper(prices, sell + 2, dp);
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        maxProfit = Math.max(maxProfit, helper(prices, day + 1, dp));

        return dp[day] = maxProfit;
    }
}
