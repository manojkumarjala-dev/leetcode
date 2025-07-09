import java.util.Arrays;

class Solution {
    int[][] max_val;

    // Binary search to find the next non-overlapping event
    public int bs(int[][] events, int idx) {
        int low = idx + 1, high = events.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (events[idx][1] < events[mid][0]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Recursive helper with memoization
    public int helper(int[][] events, int idx, int k) {
        if (idx >= events.length || k == 0) return 0;

        if (max_val[idx][k] != -1) return max_val[idx][k];

        // Option 1: Skip current event
        int skip = helper(events, idx + 1, k);

        // Option 2: Attend current event and move to next non-overlapping event
        int next_idx = bs(events, idx);
        int take = events[idx][2] + helper(events, next_idx, k - 1);

        // Memoize and return max
        max_val[idx][k] = Math.max(skip, take);
        return max_val[idx][k];
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // Sort by start time

        max_val = new int[events.length][k + 1];
        for (int[] row : max_val) Arrays.fill(row, -1);

        return helper(events, 0, k);
    }
}
