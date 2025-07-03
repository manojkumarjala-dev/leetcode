class Solution {
    private static final int MOD = 1_000_000_007;

    public int possibleStringCount(String word, int k) {
        List<Integer> groupSizes = getGroupLengths(word);
        int g = groupSizes.size();

        int maxLen = k - g;
        long total = 1;
        for (int num : groupSizes) {
            total = (total * (num + 1)) % MOD;
        }

        if (maxLen < 0) return (int) total;

        int[][] dp = new int[maxLen + 1][2];
        dp[0][0] = 1;  // Base case: empty string

        for (int i = 1; i <= g; i++) {
            int groupSize = groupSizes.get(i - 1); // Current group size

            long windowSum = 0;
            for (int j = 0; j < maxLen; j++) {
                // Add current dp[j][0] to window
                windowSum = (windowSum + dp[j][0]) % MOD;

                // If window exceeds groupSize+1, subtract the oldest value
                if (j > groupSize) {
                    windowSum = (windowSum - dp[j - groupSize - 1][0] + MOD) % MOD;
                }

                dp[j][1] = (int) windowSum;
            }

            // Copy dp[*][1] back to dp[*][0] for next group processing
            //System.out.print("dp array after "+i+" groups: [");
            for (int j = 0; j < maxLen; j++) {
                //System.out.print(dp[j][1]+",");
                dp[j][0] = dp[j][1];
                dp[j][1] = 0; // Reset for next group
            }
           // System.out.println("]");
        }

        long sub = 0;
        for (int j = 0; j < maxLen; j++) {
            sub = (sub + dp[j][0]) % MOD;
        }

        //System.out.println("total: "+total+", sub: "+sub);

        long ans = (total - sub + MOD) % MOD;
        return (int) ans;
    }

    private List<Integer> getGroupLengths(String word) {
        List<Integer> groups = new ArrayList<>();
        int n = word.length();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && word.charAt(j + 1) == word.charAt(i)) {
                j++;
            }
            groups.add(j - i);
            i = j + 1;
        }
        return groups;
    }
}
