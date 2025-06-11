class Solution {
    private int m;
    private int n;

    public boolean isValid(int row, int col) {
        return row >= 0 && row < m
                && col >= 0 && col < n;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();

        int[][] directions = {
                { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 }
        };

        int[][] minSteps = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minSteps[i], Integer.MAX_VALUE);
        }

        minSteps[0][0] = grid.get(0).get(0)==1?2:1;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { 0, 0 });

        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int[] pos = q.poll();
                for (int[] dir : directions) {
                    int nr = pos[0] + dir[0];
                    int nc = pos[1] + dir[1];

                    if (isValid(nr, nc) && minSteps[nr][nc] > (minSteps[pos[0]][pos[1]] + grid.get(nr).get(nc))) {
                        minSteps[nr][nc] = minSteps[pos[0]][pos[1]] + grid.get(nr).get(nc);
                        q.offer(new int[] { nr, nc });
                    }

                }
            }
        }

        return minSteps[m - 1][n - 1] <= health ? true : false;

    }
}