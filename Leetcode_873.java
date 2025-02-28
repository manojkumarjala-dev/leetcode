import java.util.HashMap;
import java.util.Map;

public class Leetcode_873{

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        int[][] ans = new int[arr.length][arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
            for (int j = i + 1; j < arr.length; j++) {

                if (map.containsKey(arr[j] - arr[i]) && (map.get(arr[j] - arr[i]) < i)) {
                    ans[i][j] = ans[map.get(arr[j] - arr[i])][i] + 1;

                } else {
                    ans[i][j] = 2;
                }

                max = Math.max(max, ans[i][j]);
            }
        }

        return max > 2 ? max : 0;
    }
}
}