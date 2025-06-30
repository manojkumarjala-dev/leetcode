class Solution {
    public int minIndexWithSubseqSum(List<Integer> arr, int target) {
        Set<Integer> sums = new HashSet<>();
        sums.add(0); // base case: sum of empty subset is 0
        if(target==0){
            return 0;
        }

        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            Set<Integer> newSums = new HashSet<>(sums);

            for (int sum : sums) {
                int newSum = sum + num;
                if (newSum == target) {
                    return i+1; // found target using arr[0..i]
                }
                newSums.add(newSum);
            }

            if (num == target) return i;

            newSums.add(num);
            sums = newSums;
        }

        return -1; // not possible
    }

    public int minZeroArray(int[] nums, int[][] queries) {

        List<List<Integer>> arr = new ArrayList<>();

        for(int i =0;i<nums.length;i++){
            arr.add(new ArrayList<Integer>());
        }

        for(int i =0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            int value = queries[i][2];

            for(int j =0;j<left;j++){
                arr.get(j).add(0);
            }
            for(int j=left;j<=right;j++){
                arr.get(j).add(value);
            }
            for(int j = right+1;j<nums.length;j++){
                arr.get(j).add(0);
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int returned = minIndexWithSubseqSum(arr.get(i),nums[i]);
            if( returned == -1) return -1;
            max = Math.max(max, returned);
        }

        return max;
        
    }
}