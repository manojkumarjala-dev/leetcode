class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int maxV = 100_000;
        long MOD = 1_000_000_007;
        long ans = 0L;

        int[] prefix = new int[maxV + 1];
        int[] suffix = new int[maxV + 1];


        for (int v : nums) {
            suffix[v]++;
        }


        for (int i = 0; i < n; i++) {
            int v = nums[i];


            suffix[v]--;


            if (i > 0 && i < n - 1) {
                int target = v * 2;
                if(target>100000) {
                    prefix[v]++;
                    continue;
                };
                long p = prefix[target]; 
                long s = suffix[target]; 
                //System.out.println("num:" + v + ", p:" + p + ", s:" + s+" for target:"+target);
                ans = (ans + (p % MOD) * (s % MOD)) % MOD;
            }

            prefix[v]++;
        }

        //System.out.println("answer = " + ans);

        return (int) ans;

    }
}