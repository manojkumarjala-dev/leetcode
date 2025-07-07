import java.util.*;

class Solution {
    public long minCost(int m, int n, int[][] waitCost) {
        long[][] mCost = new long[m][n];
        for (long[] arr : mCost) {
            Arrays.fill(arr, Long.MAX_VALUE);
        }

        mCost[0][0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        pq.offer(new long[]{1L, 0L, 0L});

        while (!pq.isEmpty()) {
            long[] shortestCost = pq.poll();
            int cur_row = (int) shortestCost[1];
            int cur_col = (int) shortestCost[2];
            long cur_cost = shortestCost[0];

            if (cur_row == m - 1 && cur_col == n - 1) {
                return cur_cost - waitCost[cur_row][cur_col];
            }

            int[][] dir = {
                {0, 1},
                {1, 0}
            };

            for (int[] d : dir) {
                int new_row = cur_row + d[0];
                int new_col = cur_col + d[1];

                if (new_row == m || new_col == n) continue;

                long new_cost = cur_cost + ((long)(new_row + 1) * (new_col + 1)) + waitCost[new_row][new_col];

                if (mCost[new_row][new_col] > new_cost) {
                    mCost[new_row][new_col] = new_cost;
                    pq.offer(new long[]{new_cost, new_row, new_col});
                }
            }
        }

        return mCost[m - 1][n - 1] - waitCost[m - 1][n - 1];
    }
}
