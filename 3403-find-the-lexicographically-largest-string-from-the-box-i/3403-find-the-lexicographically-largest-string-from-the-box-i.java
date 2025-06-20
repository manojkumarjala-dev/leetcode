class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1) return word;
        int max_len = word.length()-numFriends+1;
        String max_word = "";
        int[] freq = new int[26];
        char max='a';
        for(int i = 0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;

        }
        for (int i = 25; i >= 0; i--) {
            if (freq[i] > 0) {
                max = (char) (i + 'a');
                break;
            }
        }
        //System.out.println(max);

        for(int i=0;i<word.length();i++){
            if(max==word.charAt(i)){
                String sub = word.substring(i, Math.min(i + max_len, word.length()));
                if (sub.compareTo(max_word) > 0) {
                    max_word = sub;
                }
            }
        }

        return max_word;



        //clean code
        /*
        
        1. 

        */






        
    }
}