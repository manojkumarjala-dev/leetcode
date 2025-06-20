class Solution {
    public int maxDistance(String s, int k) {

        int[] directions = new int[4];
        /*
        0 - N
        1 - S
        2 - E
        3 - W
        */
        int ans = 0;

        int j = 0;
        while(j<s.length()){
            if(s.charAt(j)=='N'){
                directions[0]++;
            }
            else if(s.charAt(j)=='S'){
                directions[1]++;
            }
            else if(s.charAt(j)=='E'){
                directions[2]++;
            }
            else{
                directions[3]++;
            }
            int min_up = Math.min(directions[0],directions[1]);
            int min_side = Math.min(directions[2],directions[3]);
            int effective= (min_up+min_side<k)?(min_up+min_side):k;


            ans = Math.max(ans,((Math.abs(directions[0]-directions[1])+Math.abs(directions[2]-directions[3]))+(2*effective)));
            j++;
        }

        return ans;
        
    }
}