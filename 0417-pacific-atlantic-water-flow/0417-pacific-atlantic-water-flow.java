class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        // Initialize the border cells for both oceans
        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[]{i, 0});         // left edge (Pacific)
            atlanticQueue.offer(new int[]{i, n - 1});    // right edge (Atlantic)
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pacificQueue.offer(new int[]{0, j});         // top edge (Pacific)
            atlanticQueue.offer(new int[]{m - 1, j});    // bottom edge (Atlantic)
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }

        // Run BFS from both oceans
        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        // Collect cells that can reach both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int m = heights.length;
        int n = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n &&
                    !visited[nr][nc] &&
                    heights[nr][nc] >= heights[r][c]) {
                    
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
