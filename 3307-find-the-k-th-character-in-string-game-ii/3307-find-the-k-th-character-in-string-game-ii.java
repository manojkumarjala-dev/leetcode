import java.math.BigInteger;

class Solution {
    public static int logBase2Ceil(long m) {
        if (Long.bitCount(m) == 1) {
            return Long.numberOfTrailingZeros(m);
        } else {
            return Long.numberOfTrailingZeros(Long.highestOneBit(m)) + 1;
        }
    }

    public char kthCharacter(long k, int[] operations) {
        int opsTotal = logBase2Ceil(k) - 1;

        for (int i = 0; i < 26; i++) {
            long position = k;
            long length = 1L << (opsTotal + 1);
            char temp = (char) ('a' + i);
            int tempOps = opsTotal;

            while (tempOps >= 0) {
                if (position <= (length >> 1)) {
                    tempOps--;
                    length = length >> 1;
                    continue;
                }

                if (operations[tempOps] == 0) {
                    tempOps--;
                    length = length >> 1;
                    position = position - length;
                } else {
                    temp -= 1;
                    if (temp < 'a') {
                        temp = 'z';
                    }
                    length = length >> 1;
                    position = position - length;
                    tempOps--;
                }
            }

            if (temp == 'a') {
                return (char) ('a' + i);
            }
        }

        return 'a';
    }

}
