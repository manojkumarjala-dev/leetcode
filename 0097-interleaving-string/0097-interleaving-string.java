class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), l = s3.length();
        
        if (n + m != l) return false;

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        // Fill first column (using only s1)
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Fill first row (using only s2)
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill rest of the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int k = i + j - 1;
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k)) {
                    dp[i][j] = true;
                }
                if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k)) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][m];
    }
}
