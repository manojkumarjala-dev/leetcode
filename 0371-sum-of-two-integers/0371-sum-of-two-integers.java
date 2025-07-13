public class Solution {
    public int getSum(int a, int b) {
        int result = 0;  
        int carry = 0;   

        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;

            int sum = bitA ^ bitB ^ carry;

            result |= (sum << i);

            carry = (bitA & bitB) | (bitA & carry) | (bitB & carry);
        }

        return result;
    }
}
