import java.util.HashMap;
import java.util.Map;

public class Leetcode_3160 {
    class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> colorCountMap = new HashMap<>();
        Map<Integer,Integer> ballColorMap = new HashMap<>();
        int[] color = new int[queries.length];
        for(int i =0;i<queries.length;i++){
            if(ballColorMap.containsKey(queries[i][0])){
                colorCountMap.put(ballColorMap.get(queries[i][0]),colorCountMap.get(ballColorMap.get(queries[i][0]))-1);
                colorCountMap.remove(ballColorMap.get(queries[i][0]),0);
            }
            colorCountMap.put(queries[i][1],colorCountMap.getOrDefault(queries[i][1],0)+1);
            ballColorMap.put(queries[i][0],queries[i][1]);
            color[i] = colorCountMap.size();
        }

        return color;

    }
}
}
