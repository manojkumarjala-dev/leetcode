import java.util.*;

class Solution {
    static final int MAX = 1000000;
    static boolean[] isPrime = new boolean[MAX + 1];

    public int minOperations(int[] nums) {
        sieve(); // Fill isPrime[]

        int n = nums.length;
        int operations = 0;
        int maxSoFar = nums[n - 1]; // last stays the same

        for (int i = n - 2; i >= 0; i--) {
            int curr = nums[i];
            int steps = 0;

            while (curr > maxSoFar) {
                int divisor = greatestProperDivisor(curr);
                if (divisor == 1) return -1; // stuck on prime
                curr = curr / divisor;
                steps++;
            }

            nums[i] = curr; // apply changes
            maxSoFar = Math.min(maxSoFar, curr); // update
            operations += steps;
        }

        return operations;
    }

    private void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // Greatest proper divisor is always smallest factor > 1
    private int greatestProperDivisor(int x) {
        if (x <= 1) return 1;

        // Try from 2 up to sqrt(x)
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return x / i;
            }
        }

        // x is prime → only proper divisor is 1
        return 1;
    }
}
