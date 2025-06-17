class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int bits = 0;
        while(n>0){
            n = n>>1;
            bits++;
        }
        n = nums.length;
        if(n>=3){
            return (int)Math.pow(2,bits);
        }
        else if(n==2){
            return 2;
        }

        return 1;
    }
}