class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String,Integer> map = new HashMap<>();
        String ans = "good"; int freq = 0;
        
        Set<String> set = new HashSet<>();
        for(List<String> list : responses){
            for(String s: list){
                if(set.contains(s)) continue;

                set.add(s);
                map.put(s, map.getOrDefault(s,0)+1);
                if(map.get(s)>freq){
                    ans = s;
                    freq= map.get(s);
                }
                if(map.get(s)==freq){
                    ans = s.compareTo(ans) <= 0 ? s : ans;
                }
                
            }
            set.clear();
        }

        return ans;
        
    }
}