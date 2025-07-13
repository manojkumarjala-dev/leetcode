class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i=0;i<=n;i++){
            int temp = i;
            int count = 0;
            while(temp>0){
                if((temp & 1) == 1) count++;
                temp = temp>>1;
            }
            ans[i] = count;
        }
        
        return ans;
    }
}