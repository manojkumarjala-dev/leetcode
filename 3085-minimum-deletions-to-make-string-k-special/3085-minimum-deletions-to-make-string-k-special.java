class Solution {
    public int minimumDeletions(String word, int k) {
        
        int[] freq = new int[26];

        for(char c: word.toCharArray()){
            freq[c-'a']++;
        }
        int ans = word.length();
        for(int i = 0;i<26;i++){
            int val = freq[i];
            int res = 0;
            for(int j = 0;j<26;j++){
                if(freq[j]<val){
                    res+=freq[j];
                }
                else if(val+k<freq[j]){
                    res+=(freq[j]-k-val);
                }
            }
            ans=Math.min(res,ans);
        }
    return ans;
    }
}


