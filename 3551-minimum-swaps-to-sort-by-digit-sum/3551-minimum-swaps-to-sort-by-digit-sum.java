class Solution {
public int minSwaps(int[] nums) {
    int n = nums.length;
    // 1) Copy and sort the distinct values by (digitSum, value)
    Integer[] sorted = new Integer[n];
    for (int i = 0; i < n; i++) sorted[i] = nums[i];
    Arrays.sort(sorted, (a, b) -> {
        int sa = digitSum(a), sb = digitSum(b);
        return sa != sb ? sa - sb : a - b;
    });

    // 2) Build a HashMap<value, currentIndex>
    Map<Integer, Integer> pos = new HashMap<>(n);
    for (int i = 0; i < n; i++) pos.put(nums[i], i);

    // 3) Walk the sorted array, swapping into place
    int swaps = 0;
    for (int i = 0; i < n; i++) {
        int want = sorted[i];
        if (nums[i] != want) {
            int j = pos.get(want);            // where 'want' currently lives
            // swap nums[i] <-> nums[j]
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            swaps++;

            // update positions in the map
            pos.put(tmp, j);
            pos.put(want, i);
        }
    }
    return swaps;
}

private int digitSum(int x) {
    int s = 0;
    while (x > 0) {
        s += x % 10;
        x /= 10;
    }
    return s;
}

}
