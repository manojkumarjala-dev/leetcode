class Solution {
    public int minScore(int n, int[][] roads) {
        // build adjacency list: city → list of (neighbor, distance)
        List<int[]>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] r : roads) {
            int u = r[0], v = r[1], d = r[2];
            adj[u].add(new int[]{v, d});
            adj[v].add(new int[]{u, d});
        }

        // bfs from city 1 to find all reachable cities
        boolean[] seen = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        seen[1] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] edge : adj[u]) {
                int v = edge[0];
                if (!seen[v]) {
                    seen[v] = true;
                    q.offer(v);
                }
            }
        }

        // among every road whose both ends are seen, pick the min distance
        int ans = Integer.MAX_VALUE;
        for (int[] r : roads) {
            if (seen[r[0]] && seen[r[1]]) {
                ans = Math.min(ans, r[2]);
            }
        }

        // if n is unreachable, you can return -1 or 0 per problem statement
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
