public class Leetcode_1092 {
    class Solution {
        public String shortestCommonSupersequence(String str1, String str2) {

            int[][] dp = new int[str1.length()+1][str2.length()+1];

            for(int i = 1;i<=str1.length();i++){
                for(int j = 1; j<=str2.length();j++ ){
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1]+1;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }

            int i = str1.length(), j = str2.length(), max = dp[str1.length()][str2.length()];
            StringBuilder sb = new StringBuilder();

            while(max!=0){
                if(dp[i-1][j]==max){
                    i-=1;
                }
                else if(dp[i][j-1]==max){
                    j-=1;
                }
                else{
                    sb.insert(0,str1.charAt(i-1));
                    max--;
                    i-=1;
                    j-=1;
                }
            }
            String finalString = sb.toString();
            sb.setLength(0);
            i = 0; j = 0; int k = 0;
            while(i<str1.length() && j<str2.length() && k<finalString.length()){
                char s1 = str1.charAt(i);
                char s2 = str2.charAt(j);
                char c = finalString.charAt(k);

                if(s1!=c){
                    sb.append(s1);
                    i++;
                }
                else if(s2!=c){
                    sb.append(s2);
                    j++;
                }
                else{
                    sb.append(c);
                    k++;
                    i++;
                    j++;
                }


            }
            while(i!=str1.length()){
                sb.append(str1.charAt(i));i++;
            }
            while(j!=str2.length()){
                sb.append(str2.charAt(j));j++;
            }
            return sb.toString();


        }
    }
}
