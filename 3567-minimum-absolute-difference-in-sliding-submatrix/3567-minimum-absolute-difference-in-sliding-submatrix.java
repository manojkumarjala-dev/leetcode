class Solution {
    public int helper(int i, int j, int k, int[][] grid) {
        TreeSet<Integer> ts = new TreeSet<>();
        int[] stream = new int[k*k];
        int l=0;
        for (int row = i; row < i + k && row<grid.length; row++) {
            for (int col = j; col < j + k && col<grid[0].length; col++) {
                stream[l]=grid[row][col];
                l++;
            }
        }

        int minDiff = Integer.MAX_VALUE;
        if(k==1){
            return 0;
        }

        for (int x : stream) {
            Integer lo = ts.lower(x), hi = ts.higher(x);
            if (lo != null)
                minDiff = Math.min(minDiff, x - lo);
            if (hi != null)
                minDiff = Math.min(minDiff, hi - x);
            ts.add(x);
        }

        return minDiff==Integer.MAX_VALUE?0:minDiff;

    }

    public int[][] minAbsDiff(int[][] grid, int k) {

        int m = grid.length, n = grid[0].length;
        int min = Integer.MAX_VALUE;

        int[][] ans = new int[m - k + 1][n - k + 1];
        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                ans[i][j] = helper(i, j, k, grid);
            }
        }

        return ans;
    }
}