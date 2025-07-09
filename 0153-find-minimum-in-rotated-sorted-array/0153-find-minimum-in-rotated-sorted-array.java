class Solution {
    
    public int findMin(int[] arr) {
        int low = 0,high = arr.length-1;
        int mid = low + (high - low) / 2;
        
         while (low < high) {
             mid = low + (high - low) / 2;
            if(arr[low]<arr[high]){
            return arr[low];
        }
            // Check if x is present at mid
            if (arr[mid] >= arr[low]){
                low = mid +1;
            }
                


            else if (arr[mid] < arr[low]){
                low = low+1;
                high = mid;
            }

    }

    // If we reach here, then element was not present
    return arr[low];
    }
}