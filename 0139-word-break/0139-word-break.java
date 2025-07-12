class Solution {
    Boolean[] dp;

    boolean helper(String s, int idx, Set<String> set) {
        if (idx == s.length()) return true;
        if (dp[idx] != null) return dp[idx];

        for (int i = idx; i < s.length(); i++) {
            if (set.contains(s.substring(idx, i + 1)) && helper(s, i + 1, set)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new Boolean[n];  

        return helper(s, 0, new HashSet<>(wordDict));
    }
}
