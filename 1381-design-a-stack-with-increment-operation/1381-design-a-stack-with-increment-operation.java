class CustomStack {
    
    private Stack<Integer> stack;
    private int maxSize;

    public CustomStack(int maxSize) {
       stack = new Stack<>();
       this.maxSize = maxSize;
    }
    
    public void push(int x) {
       if(stack.size() < maxSize){
          stack.push(x);   
       }
    }
    
    public int pop() {
        if(!stack.isEmpty()){
              return stack.pop();
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for (int i = 0; i < stack.size() && i < k; i++) {
            stack.set(i, stack.get(i) + val);  // Example modification: doubling each element
        } 
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */