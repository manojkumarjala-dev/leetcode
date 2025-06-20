class Solution {
    public int longestSubarray(int[] nums, int limit) {

        PriorityQueue<int[]> minpq = new PriorityQueue<>((a, b) -> {
            return (a[0] - b[0]) != 0 ? (a[0] - b[0]) : (a[1] - b[1]);
        });
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (a, b) -> (b[0] != a[0]) ? (b[0] - a[0]) : (a[1] - b[1]));

        int i = 0;
        int j = 0;

        minpq.offer(new int[] { nums[j], j });
        maxpq.offer(new int[] { nums[j], j });
        j = 1;
        int ans = 1;
        while (j < nums.length) {
            minpq.offer(new int[] { nums[j], j });
            maxpq.offer(new int[] { nums[j], j });

            if (maxpq.peek()[1] >= i && maxpq.peek()[1] <= j
                    && minpq.peek()[1] >= i && minpq.peek()[1] <= j) {

                if (Math.abs(maxpq.peek()[0] - minpq.peek()[0]) <= limit) {
                    ans = Math.max(ans, j - i + 1);
                    j++;
                } else {
                    i = Math.min(maxpq.peek()[1], minpq.peek()[1]) + 1;
                }

            } else {
                while (!(maxpq.peek()[1] >= i && maxpq.peek()[1] <= j)) {
                    maxpq.poll();
                }
                while (!(minpq.peek()[1] >= i && minpq.peek()[1] <= j)) {
                    minpq.poll();
                }
            }
        }

        return ans;

    }
}