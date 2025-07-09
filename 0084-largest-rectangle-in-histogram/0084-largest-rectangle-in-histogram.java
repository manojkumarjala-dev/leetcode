class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] smallToLeft = new int[n];
        int[] smallToRight = new int[n];

        stack.push(0);

        for(int i = 1;i<n;i++){
            smallToLeft[i] = i;
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.size()>0){
                smallToLeft[i] = stack.peek()+1;
            }
            else{
                smallToLeft[i] = 0;
            }
            stack.push(i);
        }

        stack.clear();
        stack.push(n-1);
        smallToRight[n-1] = n-1;
        for(int i = n-2;i>=0;i--){
            smallToRight[i] = i;
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.size()>0){
                smallToRight[i] = stack.peek()-1;
            }
            else{
                smallToRight[i] = n-1;
            }
            stack.push(i);
        }

        int max = 0;

        //System.out.println(Arrays.toString(smallToLeft));
        //System.out.println(Arrays.toString(smallToRight));


        for(int i = 0;i<n;i++){
            max = Math.max((smallToRight[i]-smallToLeft[i]+1)*heights[i],max);
        }


        return max;
        
    }
}