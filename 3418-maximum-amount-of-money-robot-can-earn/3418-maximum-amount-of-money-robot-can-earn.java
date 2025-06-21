class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] ans = new int[m][n][3];

        int NEG = Integer.MIN_VALUE;     // sentinel “-∞”

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < 3; k++)
                    ans[i][j][k] = NEG;  

        ans[0][0][0] = coins[0][0];
        ans[0][0][1] = Math.max(coins[0][0],0);
        ans[0][0][2] = Math.max(coins[0][0],0);


        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0;k<3;k++){
                    if( i==0 && j==0) continue;
                    int gain = coins[i][j];
                    if(i>0){
                        ans[i][j][k] = Math.max(ans[i][j][k],ans[i-1][j][k]+gain);
                        if(k>0 && gain<0){
                            ans[i][j][k] = Math.max(ans[i][j][k],ans[i-1][j][k-1]);
                        }
                    }
                    if(j>0){
                        ans[i][j][k] = Math.max(ans[i][j][k],ans[i][j-1][k]+gain);
                        if(k>0 && gain<0){
                            ans[i][j][k] = Math.max(ans[i][j][k],ans[i][j-1][k-1]);
                        }
                    }
                }
            }
        }

        return Math.max(ans[m-1][n-1][0],Math.max(ans[m-1][n-1][1],ans[m-1][n-1][2]));


    }

}