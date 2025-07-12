class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] cost = new int[amount+1];
        Arrays.fill(cost, 0);

        if(amount==0) return 0;

        for(int i = 0;i<coins.length;i++){
            if(coins[i]>amount) continue;
            cost[coins[i]]=1;
        }
        //System.out.println(Arrays.toString(cost));

        for(int i = 1;i<=amount;i++){
            if(cost[i] == 1) continue;
            for(int j = 0;j<coins.length;j++){
                if(coins[j]<i && cost[i-coins[j]]!=0){
                    if(cost[i]==0){
                        cost[i] = 1+cost[i-coins[j]];
                    }
                    else{
                        cost[i] = Math.min(cost[i],1+cost[i-coins[j]]);
                    }
                }
            }
        }

        //System.out.println(Arrays.toString(cost));

        return cost[amount]!=0?cost[amount]:-1;

    }
}