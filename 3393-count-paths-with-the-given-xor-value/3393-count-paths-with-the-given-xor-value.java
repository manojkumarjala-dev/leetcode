class Solution {
    public int countPathsWithXorValue(int[][] grid, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0, grid[0][0]});
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        int MOD = 1000000007;
        int[][][] dp = new int[m][n][16];
        int val = grid[0][0];
        for(int i = 1;i<n;i++){
            val^=grid[0][i];
            dp[0][i][val]++;
        }
        val = grid[0][0];
        for(int i = 1;i<m;i++){
            val^=grid[i][0];
            dp[i][0][val]++;
        }

        for( int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                for(int l = 0;l<16;l++){
                    dp[i][j][l^grid[i][j]]=(dp[i][j][l^grid[i][j]]+dp[i-1][j][l])%MOD;
                    dp[i][j][l^grid[i][j]]=(dp[i][j][l^grid[i][j]]+dp[i][j-1][l])%MOD;
                }
            }
        }

        return dp[m-1][n-1][k];

    }
}