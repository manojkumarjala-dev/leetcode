class TimeMap {
    class Pair{
        String s;
        int timestamp;

        public Pair(String s, int timestamp){
            this.s = s;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
 if (!map.containsKey(key)) {
    List<Pair> values = new ArrayList<>();
    values.add(new Pair(value, timestamp));
    map.put(key, values); // new list added
} else {
    List<Pair> values = map.get(key);
    values.add(new Pair(value, timestamp)); // just add — no need to put again
    // No map.put needed — you're modifying the list already inside the map
}
    }
    
    public String get(String key, int timestamp) {
        List<Pair> values = map.get(key);
        if(values == null) return "";
        int low = 0, high = values.size()-1;
        int min = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            int t = values.get(mid).timestamp;
            if(t == timestamp) return values.get(mid).s;
            if(t>timestamp){
                high = mid-1;
            }
            else{
                min = mid;
                low = mid+1;
            }
        }

        return min==-1?"":values.get(min).s;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */