class Solution {
    public long maxScore(int n, int[][] edges) {
        int e = edges.length;
        int ans = 0;
        if(e==n){
            ans+=2;
        }
        int i = n;
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3 && e==3){
            return 11;
        }
        if(n==3 && e==2){
            return 9;
        }


        ans+=(i*(i-1));
        ans+=(i*(i-2));

        int x = i-1, y= i-3;

        while(y>=1){
            ans+=(x*y);
            x--;
            y--;
        }


        return ans;
    }
}