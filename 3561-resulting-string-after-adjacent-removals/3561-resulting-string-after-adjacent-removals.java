class Solution {
    public String resultingString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(stack.size()>0 && (stack.peek()==s.charAt(i)+1||stack.peek()==s.charAt(i)-1)){
                stack.pop();
                continue;
            }
            if(stack.size()>0 && (stack.peek()=='a') && (s.charAt(i)=='b'||s.charAt(i)=='z')){
                stack.pop();
                continue;
            }
            if(stack.size()>0 && (stack.peek()=='z') && (s.charAt(i)=='a'||s.charAt(i)=='y')){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(stack.size()>0){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}