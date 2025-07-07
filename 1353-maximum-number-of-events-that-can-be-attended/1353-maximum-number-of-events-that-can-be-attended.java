import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> minEndPQ = new PriorityQueue<>();
        int i = 0, n = events.length;
        int day = 0, attended = 0;

        while (i < n || !minEndPQ.isEmpty()) {
            // Move to the next available event day if heap is empty
            if (minEndPQ.isEmpty()) {
                day = events[i][0];
            }

            // Add all events starting today
            while (i < n && events[i][0] == day) {
                minEndPQ.offer(events[i][1]); // Push the end day
                i++;
            }

            // Remove all events that have already expired
            while (!minEndPQ.isEmpty() && minEndPQ.peek() < day) {
                minEndPQ.poll();
            }

            // Attend one event (with the earliest end)
            if (!minEndPQ.isEmpty()) {
                minEndPQ.poll();
                attended++;
                day++;
            }
        }

        return attended;
    }
}
