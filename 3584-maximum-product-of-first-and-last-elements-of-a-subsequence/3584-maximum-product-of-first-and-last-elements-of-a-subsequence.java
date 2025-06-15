class Solution {
    private long ans;

    private int ceilPowerOfTwo(int n) {
        if (n <= 1) return 1;
        if ((n & (n - 1)) == 0) return n;
        return Integer.highestOneBit(n) << 1;
    }

    private void constructTree(int[] nums, int[] segMin, int[] segMax, int low, int high, int pos) {
        if (low == high) {
            segMin[pos] = nums[low];
            segMax[pos] = nums[low];
            return;
        }
        int mid = low + (high - low) / 2;
        // left child
        constructTree(nums, segMin, segMax, low, mid,  2 * pos + 1);
        // right child
        constructTree(nums, segMin, segMax, mid + 1, high, 2 * pos + 2);

        segMin[pos] = Math.min(segMin[2 * pos + 1], segMin[2 * pos + 2]);
        segMax[pos] = Math.max(segMax[2 * pos + 1], segMax[2 * pos + 2]);
    }

    private int rangeQuery(int[] seg, int ql, int qh, int low, int high, int pos, boolean isMin) {
        if (ql <= low && high <= qh) {
            return seg[pos];
        }
        if (qh < low || ql > high) {
            return isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        int mid = low + (high - low) / 2;
        int left  = rangeQuery(seg, ql, qh, low,     mid, 2 * pos + 1, isMin);
        int right = rangeQuery(seg, ql, qh, mid + 1, high, 2 * pos + 2, isMin);
        return isMin ? Math.min(left, right) : Math.max(left, right);
    }

    private int min_max(int[] segMin, int[] segMax,
                        int ql, int qh, int low, int high, int pos, boolean isMin) {
        return isMin
            ? rangeQuery(segMin, ql, qh, low, high, pos, true)
            : rangeQuery(segMax, ql, qh, low, high, pos, false);
    }

public long maximumProduct(int[] nums, int m) {
    int n = nums.length;

    ans = Long.MIN_VALUE;

    int size = 4 * n;
    int[] segMin = new int[size];
    int[] segMax = new int[size];
    constructTree(nums, segMin, segMax, 0, n - 1, 0);

    for (int i = 0; i < n; i++) {
        int low  = i + m - 1;
        int high = n - 1;

        if (low > high) break;

        long cur;
        if (nums[i] < 0) {
            cur = (long) nums[i] 
                * min_max(segMin, segMax, low, high, 0, n - 1, 0, true);
        } else {
            cur = (long) nums[i] 
                * min_max(segMin, segMax, low, high, 0, n - 1, 0, false);
        }
        ans = Math.max(ans, cur);
    }

    return ans;
}

}
