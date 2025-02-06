import java.util.Stack;

class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x); // Always push to pushStack
    }

    public int pop() {
        shiftStacks(); // Move elements if needed
        return popStack.pop();
    }

    public int peek() {
        shiftStacks(); // Move elements if needed
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void shiftStacks() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop()); // Transfer elements to reverse order
            }
        }
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */