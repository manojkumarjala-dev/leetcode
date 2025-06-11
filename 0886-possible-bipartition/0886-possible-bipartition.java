class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {

        Map<Integer, Integer> map = new HashMap<>();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < dislikes.length; i++) {
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int[] visited = new int[n + 1];

        for (int i = 1; i < n; i++) {

            if (visited[i] == 1)
                continue;
            if (adj.get(i).size() == 0)
                continue;

            
            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            int toggle = 0;
            map.put(i,toggle);
            visited[i] = 1;
            toggle = 1;
            while (q.size() > 0) {
                int size = q.size();

                while (size-- > 0) {

                    int val = q.poll();

                    List<Integer> adjacents = adj.get(val);
                    for (int j : adjacents) {
                        if(visited[j]==1 && toggle!=map.get(j)) return false;
                        if(visited[j]==1 && toggle==map.get(j)) continue;
                        visited[j] = 1;
                        map.put(j,toggle);
                        q.add(j);
                    }

                }
                toggle = (toggle + 1) % 2;
            }
            
        }

        return true;
    }
}