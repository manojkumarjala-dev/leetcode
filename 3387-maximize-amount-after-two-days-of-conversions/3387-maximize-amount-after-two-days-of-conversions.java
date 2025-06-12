import java.util.*;

public class Solution {
    public double maxAmount(
        String initialCurrency,
        List<List<String>> pairs1, double[] rates1,
        List<List<String>> pairs2, double[] rates2
    ) {
        // 1) Index all currencies
        Map<String,Integer> map = new HashMap<>();
        map.put(initialCurrency, 0);
        int counter = 1;
        for (List<String> p : pairs1) {
            for (String c : p) {
                if (!map.containsKey(c)) {
                    map.put(c, counter++);
                }
            }
        }
        for (List<String> p : pairs2) {
            for (String c : p) {
                if (!map.containsKey(c)) {
                    map.put(c, counter++);
                }
            }
        }

        // 2) Build day-1 adjacency list: each edge is [to, rate]
        List<List<double[]>> adj1 = new ArrayList<>();
        for (int i = 0; i < counter; i++) adj1.add(new ArrayList<>());
        for (int i = 0; i < pairs1.size(); i++) {
            int u = map.get(pairs1.get(i).get(0));
            int v = map.get(pairs1.get(i).get(1));
            adj1.get(u).add(new double[]{ v, rates1[i] });
        }

        // 3) BFS day-1 to collect all (currency, amount) states
        List<double[]> day1Results = new ArrayList<>();
        boolean[] seen1 = new boolean[counter];
        Queue<double[]> q1 = new LinkedList<>();
        q1.offer(new double[]{ map.get(initialCurrency), 1.0 });
        while (!q1.isEmpty()) {
            double[] cur = q1.poll();
            int curC = (int) cur[0];
            double amt = cur[1];
            if (seen1[curC]) continue;
            seen1[curC] = true;
            day1Results.add(cur);
            for (double[] edge : adj1.get(curC)) {
                int nxt = (int) edge[0];
                double rate = edge[1];
                q1.offer(new double[]{ nxt, amt * rate });
            }
        }

        // 4) Build day-2 adjacency, adding both forward and reciprocal edges
        List<List<double[]>> adj2 = new ArrayList<>();
        for (int i = 0; i < counter; i++) adj2.add(new ArrayList<>());
        for (int i = 0; i < pairs2.size(); i++) {
            int u = map.get(pairs2.get(i).get(0));
            int v = map.get(pairs2.get(i).get(1));
            double r = rates2[i];
            adj2.get(u).add(new double[]{ v, r });
            adj2.get(v).add(new double[]{ u, 1.0 / r });
        }

        // 5) From each day-1 state, BFS day-2 and track the max returning to initialCurrency
        double maxAmt = 0.0;
        int startIdx = map.get(initialCurrency);
        for (double[] st : day1Results) {
            boolean[] seen2 = new boolean[counter];
            Queue<double[]> q2 = new LinkedList<>();
            q2.offer(st);
            while (!q2.isEmpty()) {
                double[] cur = q2.poll();
                int curC = (int) cur[0];
                double amt = cur[1];
                if (curC == startIdx) {
                    maxAmt = Math.max(maxAmt, amt);
                    continue;
                }
                if (seen2[curC]) continue;
                seen2[curC] = true;
                for (double[] edge : adj2.get(curC)) {
                    int nxt = (int) edge[0];
                    double rate = edge[1];
                    q2.offer(new double[]{ nxt, amt * rate });
                }
            }
        }

        return maxAmt;
    }
}
