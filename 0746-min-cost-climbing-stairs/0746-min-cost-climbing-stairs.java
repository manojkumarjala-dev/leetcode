class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n  = cost.length;
        int[] totalCost = new int[n+1];

        if(n==1) return 0;

        totalCost[0] = 0;
        totalCost[1] = 0;
        for(int i = 2;i<=n;i++){
            totalCost[i] = Math.min(totalCost[i-1]+cost[i-1], totalCost[i-2] + cost[i-2]);
        }

        return totalCost[n];
    }
}