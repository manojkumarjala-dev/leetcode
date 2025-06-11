class Solution {
    public int bfs(List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int n = adj.size();

        int[] level = new int[n];

        Arrays.fill(level, Integer.MAX_VALUE);

        level[0] = 0;
        q.offer(0);
        int step = 1;
        while (q.size() > 0) {
            int size = q.size();

            while (size-- > 0) {
                int val = q.poll();
                List<Integer> neis = adj.get(val);

                for (int nei : neis) {
                    if (level[nei] > step) {
                        level[nei] = step;
                        q.offer(nei);
                    }
                }
            }
            step++;
        }

        return level[n - 1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n - 1; i++) {
            adj.get(i).add(i + 1);
        }

        int t = queries.length;

        int[] ans = new int[t];

        for (int i = 0; i < t; i++) {
            adj.get(queries[i][0]).add(queries[i][1]);
            ans[i] = bfs(adj);
        }

        return ans;

    }
}