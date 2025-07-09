class Solution {
    public boolean isValid(StringBuilder sb) {
        int balance = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0)
                return false;
        }
        return balance == 0;
    }

    public void helper(StringBuilder sb, int open, int n, List<String> ans) {
        if (sb.length() == n * 2) {
            if (isValid(sb)) {
                ans.add(sb.toString());
            }
            return;
        }

        sb.append('(');
        helper(sb, open + 1, n, ans);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        helper(sb, open, n, ans);
        sb.deleteCharAt(sb.length() - 1);

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb, 0, n, ans);

        return ans;

    }
}