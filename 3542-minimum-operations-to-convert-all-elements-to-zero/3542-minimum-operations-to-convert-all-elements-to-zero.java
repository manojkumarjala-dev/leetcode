import java.util.Stack;

class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> s = new Stack<>();
        s.push(0);

        int i = 0, ans = 0;
        while (i < nums.length) {
            if (s.peek() < nums[i]) {
                s.push(nums[i]);
                i++;
                ans++;
            } else if (s.peek() == nums[i]) {
                i++;               
            } else {
                s.pop();           
            }
        }
        return ans;
    }
}
