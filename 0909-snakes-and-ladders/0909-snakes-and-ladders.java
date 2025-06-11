import java.util.*;

class Solution {
    // Convert a 1-based square number to (row, col) on the boustrophedon board
    private int[] getRC(int n, int num) {
        int row = n - 1 - (num - 1) / n;
        int col = (num - 1) % n;
        // reverse direction on every other row from the bottom
        if ((n - 1 - row) % 2 == 1) {
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        int[] steps = new int[target + 1];
        Arrays.fill(steps, -1);

        Queue<Integer> q = new LinkedList<>();
        steps[1] = 0;
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();
            // early exit if we've reached the last square
            if (cur == target) {
                return steps[cur];
            }
            // try all dice rolls 1 through 6
            for (int move = 1; move <= 6 && cur + move <= target; move++) {
                int next = cur + move;
                int[] rc = getRC(n, next);
                int row = rc[0], col = rc[1];
                // if there's a snake or ladder, take it
                if (board[row][col] != -1) {
                    next = board[row][col];
                }
                // if unvisited, record step count and enqueue
                if (steps[next] == -1) {
                    steps[next] = steps[cur] + 1;
                    q.offer(next);
                }
            }
        }


        return -1;
    }
}
