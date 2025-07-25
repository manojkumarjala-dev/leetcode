class Solution {
    public int countSubstrings(String s) {
        // odd length strings
        int ans = s.length();
        int n = s.length();
        int start = 0, end = 0, max_len = 0;

        for(int i = 0;i<n;i++){
            int left = i-1, right = i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                if(right-left+1>max_len){
                    max_len = right-left+1;
                    start = left; end = right;
                }
                left--;right++;
                ans++;
            }
        }

        // even lengths
        for(int i = 0;i<n-1;i++){
            int left = i, right = i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                if(right-left+1>max_len){
                    max_len = right-left+1;
                    start = left; end = right;
                }
                left--;right++;
                ans++;
            }
        }

        return ans;
    }
}