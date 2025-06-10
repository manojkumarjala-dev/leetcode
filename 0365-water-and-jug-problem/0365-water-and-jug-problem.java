class Solution {

    public boolean canMeasureWater(int x, int y, int target) {
        int[][] matrix = new int[x + 1][y + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });

        matrix[0][0] = 1;

        int maxX = x, maxY = y;

        int i = 0;
        while (q.size() > 0) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                x = curr[0];
                y = curr[1];
                if (x == target || y == target || x + y == target) {
                    return true;
                }
                int[][] next = new int[][] {
                        { maxX, y }, // fill X
                        { x, maxY }, // fill Y
                        { 0, y }, // empty X
                        { x, 0 }, // empty Y
                        { x - Math.min(x, maxY - y), y + Math.min(x, maxY - y) }, // pour X→Y
                        { x + Math.min(y, maxX - x), y - Math.min(y, maxX - x) } // pour Y→X
                };

                for (int[] st : next) {
                    int nx = st[0];
                    int ny = st[1];
                    if (matrix[nx][ny] == 0) {

                        matrix[nx][ny] = 1;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
            i++;
        }

        return false;
    }
}