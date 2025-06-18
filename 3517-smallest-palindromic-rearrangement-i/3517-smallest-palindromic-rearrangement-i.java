class Solution {
    public String smallestPalindrome(String s) {

        int[] letters = new int[26];            
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            int k = letters[i] / 2;            
            char ch = (char) ('a' + i);
            for (int j = 0; j < k; j++) {
                ans.append(ch);
            }
        }

        for (int i = 25; i >= 0; i--) {
            int k = letters[i] / 2;
            char ch = (char) ('a' + i);
            for (int j = 0; j < k; j++) {
                ans.append(ch);
            }
        }
        for (int i = 25; i >= 0; i--) {
            if(letters[i]%2==1){
                char ch = (char) ('a' + i);
                ans.insert(s.length()/2,ch);
            }
        }

        return ans.toString();
    }
}
