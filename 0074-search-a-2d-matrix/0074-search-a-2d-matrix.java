class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length;

        while(low<high){
            int mid = low + (high - low)/2;
            if(matrix[mid][0]==target) return true;

            if(matrix[mid][0]>target) high = mid;
            else low = mid+1;
        }

        int idx = low-1;
        if(idx<0) return false;


        low = 0; high = matrix[idx].length;

        
        while(low<high){
            int mid = low + (high - low)/2;
            if(matrix[idx][mid]==target) return true;

            if(matrix[idx][mid]>target) high = mid;
            else low = mid+1;
        }

        return false;
    }
}