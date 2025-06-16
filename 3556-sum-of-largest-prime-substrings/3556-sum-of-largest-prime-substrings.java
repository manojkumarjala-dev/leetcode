class Solution {
    boolean isPrime(long n) {
        if (n < 2)
            return false;
        if (n % 2 == 0)
            return n == 2;
        if (n % 3 == 0)
            return n == 3;
        int r = (int) Math.sqrt(n);
        for (int i = 5; i <= r; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public long sumOfLargestPrimes(String s) {
        Map<Long, Integer> map = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                long v = Long.parseLong(sub);
                if (isPrime(v)) {
                    map.put(v, map.getOrDefault(v, 0) + 1);
                }
            }
        }

        long sum = 0, cnt = 0;
        for (long key : ((TreeMap<Long, Integer>) map).descendingKeySet()) {
            sum += key;
            if (++cnt == 3)
                break;
        }
        return sum;

    }
}