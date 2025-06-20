class Solution {
    public long calculateScore(String s) {

        List<List<Integer>> position = new ArrayList<>();
        for(int i =0;i<26;i++){
            position.add(new ArrayList<Integer>());
        }
        int ans  = 0;

        for( int i =0;i<s.length();i++){
            char mirror = (char) ('a' + ('z' - s.charAt(i)));
            if(position.get(mirror-'a').size()==0){
                position.get(s.charAt(i)-'a').add(i);
                continue;
            }

            int pos = position.get(mirror-'a').get(position.get(mirror-'a').size()-1);
            ans+=(i-pos);

            position.get(mirror-'a').remove(position.get(mirror-'a').size()-1);
        }
        return ans;
    }
}