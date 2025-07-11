class Solution {
    void helper(String digits, int idx, Map<Character, String> map, StringBuilder str, List<String> ans){

        if(idx == digits.length()){
            ans.add(str.toString());
            return;
        }

        String s = map.get(digits.charAt(idx));

        for(char c: s.toCharArray()){
            str.append(c);
            helper(digits, idx+1, map, str, ans);
            str.deleteCharAt(str.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {

        Map<Character, String> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits.length()==0) return ans;

        helper(digits, 0, map, new StringBuilder(),ans);

        return ans;

    }
}