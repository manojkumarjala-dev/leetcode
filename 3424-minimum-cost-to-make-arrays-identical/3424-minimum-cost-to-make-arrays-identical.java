class Solution {
    public static boolean isSorted(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    public long minCost(int[] arr, int[] brr, long k) {
        long ans2=0;
        for(int i =0;i<arr.length;i++){
            ans2+=Math.abs(arr[i]-brr[i]);
        }
        long ans = 0;
        if (isSorted(arr)) {
            if(isSorted(brr)){
                ans = 0;
            }
            else{
                ans+=k;
                Arrays.sort(brr);
                Arrays.sort(arr);
            }
        } else {
            Arrays.sort(arr);
            Arrays.sort(brr);
            ans+=k;
        }

        for(int i =0;i<arr.length;i++){
            ans+=Math.abs(arr[i]-brr[i]);
        }

        return Math.min(ans,ans2);
        
    }

}

