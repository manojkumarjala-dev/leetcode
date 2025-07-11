class Solution {
    void helper(String word, List<List<String>> ans, List<String> current, int idx){
        if(idx == word.length()) ans.add(new ArrayList<String>(current));

            for(int end = idx;end<word.length();end++){
                if(isPalindrome(word, idx,end)){
                    current.add(word.substring(idx,end+1));
                    helper(word, ans, current, end+1);
                    current.remove(current.size()-1);
                }
            }
        }
    

    boolean isPalindrome(String word, int start, int end){
        while(start<end){
            if(word.charAt(start)!=word.charAt(end)) return false;
            start++;end--;
        }

        return true;
    }
    public List<List<String>> partition(String s) { 

        List<List<String>> ans = new ArrayList<>();
        List<String> current = new ArrayList<>();

        helper(s,ans,current,0);

        return ans;
        
    }
}