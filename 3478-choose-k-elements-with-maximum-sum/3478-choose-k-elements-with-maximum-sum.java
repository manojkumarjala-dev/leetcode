class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] mapped = new int[n][3];

        for (int i = 0; i < n; i++) {
            mapped[i] = new int[] { i, nums1[i], nums2[i] };
        }

        Arrays.sort(mapped, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0;
        long[] return_ans = new long[n];

        for (int i = 0; i < n; i++) {
            int[] cur = mapped[i];
            return_ans[cur[0]] = sum;
            if (i >= 1 && mapped[i][1] == mapped[i - 1][1]) {
                return_ans[cur[0]] = return_ans[mapped[i - 1][0]];
            }
            

            sum += cur[2];
            pq.offer(cur[2]);

            if (pq.size() > k) {
                sum -= pq.poll();
            }

        }

        return return_ans;
    }
}
