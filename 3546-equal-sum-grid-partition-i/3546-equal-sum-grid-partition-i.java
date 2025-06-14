class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        long[] rowSum = new long[m];
        long[] colSum = new long[n];
        long totalRowSum = 0;
        long totalColSum = 0;
        for(int i =0;i<m;i++){
            long rSum = 0;
            for(int j = 0;j<n;j++){
                rSum+=grid[i][j];
                totalRowSum+=grid[i][j];
            }
            rowSum[i] = rSum;
        }

        for(int i =0;i<n;i++){
            long cSum = 0;
            for(int j = 0;j<m;j++){
                cSum+=grid[j][i];
                totalColSum+=grid[j][i];
            }
            colSum[i] = cSum;
        }
        long checkRow = 0;long checkCol = 0;
        for(int i = 0;i<m;i++){
            checkRow+=rowSum[i];
            if(checkRow*2==totalRowSum){
                return true;
            }
        }

        for(int i = 0;i<n;i++){
            checkCol+=colSum[i];
            if(checkCol*2==totalColSum){
                return true;
            }
        }

        return false;
        
    }
}