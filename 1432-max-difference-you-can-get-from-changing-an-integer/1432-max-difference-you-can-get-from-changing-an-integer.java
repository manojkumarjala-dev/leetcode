class Solution {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        String small = s;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }

        if (small.charAt(0) != '1') {
            small = small.replace(small.charAt(0), '1');
        } else {
            pos = 0;
            while (pos < small.length() && small.charAt(pos) <= '1') {
                pos++;
            }
            if (pos < small.length()) {
                small = small.replace(small.charAt(pos), '0');
            }
        }

        return Integer.parseInt(s) - Integer.parseInt(small);


    }
}