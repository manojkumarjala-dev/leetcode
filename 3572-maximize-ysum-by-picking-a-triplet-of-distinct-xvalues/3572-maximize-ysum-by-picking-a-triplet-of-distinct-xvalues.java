class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int[] freq = new int[1_000_001];
        for (int i = 0; i < x.length; i++) {
            freq[x[i]] = Math.max(freq[x[i]], y[i]);
        }

        int first = 0, second = 0, third = 0;
        for (int v : freq) {
            if (v > first) {
                third  = second;
                second = first;
                first  = v;
            }
            else if (v > second) {
                third  = second;
                second = v;
            }
            else if (v > third) {
                third = v;
            }
        }

        return (third > 0)
            ? first + second + third
            : -1;
    }
}
