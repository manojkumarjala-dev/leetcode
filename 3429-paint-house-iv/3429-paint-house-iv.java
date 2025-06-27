class Solution {
    /*

        core idea is using symmetry and only 3 colors 
        max possible pairs are 6 such that both are not same
        now for outer we have all the possibilities
        but when u move one step inside
        the choices narrowed down to 3
        If outer is 01 -> inner can only be 10,20,12 so we take only min of those

    */
    public long minCost(int n, int[][] cost) {
        long[][] dp = new long[n / 2][6]; 


        int[][] pairs = {
            {0, 1}, {0, 2},
            {1, 0}, {1, 2},
            {2, 0}, {2, 1}
        };


        for (int idx = 0; idx < 6; idx++) {
            int i = pairs[idx][0];
            int j = pairs[idx][1];
            dp[0][idx] = cost[0][i] + cost[n - 1][j];
        }


        for (int k = 1; k < n / 2; k++) {
            for (int curr = 0; curr < 6; curr++) {
                int i = pairs[curr][0];           
                int j = pairs[curr][1];           

                long minPrev = Long.MAX_VALUE;


                for (int prev = 0; prev < 6; prev++) {
                    int pi = pairs[prev][0];
                    int pj = pairs[prev][1];


                    if (pi != i && pj != j) {
                        minPrev = Math.min(minPrev, dp[k - 1][prev]);
                    }
                }

                dp[k][curr] = cost[k][i] + cost[n - 1 - k][j] + minPrev;
            }
        }


        long ans = Long.MAX_VALUE;
        for (long val : dp[n / 2 - 1]) {
            ans = Math.min(ans, val);
        }

        return ans;
    }
}

