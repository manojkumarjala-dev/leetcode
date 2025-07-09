class MinStack {
List<Integer> stack;
List<Integer> minStack;
    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int value) {

        if(stack.size()==0){
            stack.add(value);
            minStack.add(value);
        }
        else{

            stack.add(value);
            minStack.add(Math.min(minStack.get(minStack.size()-1),value));

        }
        
    }
    
    public void pop() {

        minStack.remove(minStack.size()-1);
        stack.remove(stack.size()-1);
        
    }
    
    public int top() {

        return stack.get(stack.size()-1);
        
    }
    
    public int getMin() {
        return minStack.get(minStack.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */