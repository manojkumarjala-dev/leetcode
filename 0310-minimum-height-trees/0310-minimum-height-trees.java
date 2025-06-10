class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) return Collections.singletonList(0);
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0], end = edges[i][1];

            adj.get(start).add(end);
            adj.get(end).add(start);
        }

        Deque<Integer> leaves = new LinkedList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.offerFirst(i);
            }
            inDegree[i] = adj.get(i).size();
        }

        int remaining = n;
        while (remaining > 2) {
            int leafCount = leaves.size();
            remaining -= leafCount;

            for (int i = 0; i < leafCount; i++) {
                int leaf = leaves.poll();
                for (int nei : adj.get(leaf)) {
                    if (--inDegree[nei] == 1) {
                        leaves.offer(nei);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>(leaves);
        return list;
    }
}