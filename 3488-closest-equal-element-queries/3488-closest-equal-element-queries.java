class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            TreeSet<Integer> set = map.getOrDefault(nums[i], new TreeSet<Integer>());
            set.add(i);
            map.put(nums[i],set);
        }

        for(int i = 0;i<queries.length;i++){
            int q = queries[i];
            int num = nums[q];
            //System.out.println(map.get(num));

            Integer ceil = map.get(num).higher(q);
            Integer floor = map.get(num).lower(q);


            if(ceil==null && floor==null){
                ans.add(-1);
            }
            else if(ceil!=null && floor!=null){
                ans.add(Math.min(q-floor,ceil-q));
            }
            else if(ceil!=null){
                Integer last_idx = map.get(num).last(); 
                int dist = nums.length+q-last_idx;
                ans.add(Math.min(dist, Math.min(ceil-q, q+(nums.length-ceil))));
            }
            else{
                Integer first_idx = map.get(num).first(); 
                int dist = nums.length-q+first_idx;
                ans.add(Math.min(dist,Math.min(q-floor, floor+(nums.length-q))));
            }


        }

        return ans;
        
    }
}