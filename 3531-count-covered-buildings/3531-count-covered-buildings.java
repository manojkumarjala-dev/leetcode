class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[][] x = new int[n + 1][2];
        int[][] y = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            x[i][0] = y[i][0] = Integer.MAX_VALUE;
            x[i][1] = y[i][1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < buildings.length; i++) {
            int b_x = buildings[i][0];
            int b_y = buildings[i][1];

            x[b_x][0] = Math.min(b_y, x[b_x][0]);  
            x[b_x][1] = Math.max(b_y, x[b_x][1]);  

            y[b_y][0] = Math.min(b_x, y[b_y][0]);  
            y[b_y][1] = Math.max(b_x, y[b_y][1]); 


        }
        // for(int i =1;i<=n;i++){
        //     System.out.println("Limits of x at y:"+i+" are "+y[i][0]+" - "+y[i][1]);
        //     System.out.println("Limits of y at x:"+i+" are "+x[i][0]+" - "+x[i][1]);
        // }
        int ans = 0;
        for (int i = 0; i < buildings.length; i++) {
            int b_x = buildings[i][0];
            int b_y = buildings[i][1];

            if (x[b_x][0] < b_y && b_y < x[b_x][1] &&
                    y[b_y][0] < b_x && b_x < y[b_y][1]) {
                ans++;
            }
        }

        return ans;

    }
}