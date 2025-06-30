class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100_005;
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];

    // Precompute factorials and inverse factorials
    public static void precompute() {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    // Modular inverse using Fermat's little theorem
    public static long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    public static long pow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public static int minMaxSums(int[] nums, int k) {
        precompute();
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;

        for (int i = 0; i < n; i++) {
            // As min
            int right = n - i - 1;
            for (int size = 1; size <= k; size++) {
                int choose = size - 1;
                if (right >= choose) {
                    long ways = nCr(right, choose);
                    total = (total + nums[i] * ways % MOD) % MOD;
                }
            }

            // As max
            int left = i;
            for (int size = 1; size <= k; size++) {
                int choose = size - 1;
                if (left >= choose) {
                    long ways = nCr(left, choose);
                    total = (total + nums[i] * ways % MOD) % MOD;
                }
            }
        }

        return (int) total;
    }
}