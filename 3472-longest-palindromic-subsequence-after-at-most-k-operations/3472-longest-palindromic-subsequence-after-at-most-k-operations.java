class Solution {
    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();
        Integer[][][] dp = new Integer[n][n][k + 1];
        return dfs(0, n - 1, k, s.toCharArray(), dp);
    }

    private int dfs(int i, int j, int kLeft, char[] s, Integer[][][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j][kLeft] != null) return dp[i][j][kLeft];

        int best = 0;

        if (s[i] == s[j]) {
            best = 2 + dfs(i + 1, j - 1, kLeft, s, dp);
        } else {
            int cost = getDistance(s[i], s[j]);
            if (kLeft >= cost) {
                best = Math.max(best, 2 + dfs(i + 1, j - 1, kLeft - cost, s, dp));
            }
        }

        best = Math.max(best, dfs(i + 1, j, kLeft, s, dp));
        best = Math.max(best, dfs(i, j - 1, kLeft, s, dp));

        return dp[i][j][kLeft] = best;
    }

    private int getDistance(char a, char b) {
        int diff = Math.abs(a - b);
        return Math.min(diff, 26 - diff);
    }
}
