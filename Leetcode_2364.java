import java.util.HashMap;
import java.util.Map;

public class Leetcode_2364 {
    class Solution {
    public long countBadPairs(int[] nums) {
        
        long ans = 0;
        Map<Integer,Long> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            nums[i]-=i;
            map.put(nums[i],map.getOrDefault(nums[i],(long)0)+1);
        }
        
        for(Map.Entry<Integer,Long> entry : map.entrySet()){
            long value = entry.getValue();
            ans += (value*(value-1)/2);
        }
         long len = nums.length;
        return (len*(len-1)/2) - ans;
    }
}
    
}
