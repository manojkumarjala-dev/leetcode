class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int[] bound = new int[]{bounds[0][0],bounds[0][1]};

        for(int i = 1;i<original.length;i++){
            int diff = original[i]-original[i-1];
            bound[0] = Math.max(bound[0]+diff, bounds[i][0]);
            bound[1] = Math.min(bound[1]+diff, bounds[i][1]);
        }
        
        return bound[1]-bound[0]+1<0?0:bound[1]-bound[0]+1;
    }
}