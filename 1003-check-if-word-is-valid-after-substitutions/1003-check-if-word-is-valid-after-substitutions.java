import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // Push current character onto the stack
            stack.push(ch);
            
            // Check if the top three characters form "abc"
            if (stack.size() >= 3) {
                int top = stack.size();
                if (stack.get(top - 3) == 'a' && stack.get(top - 2) == 'b' && stack.get(top - 1) == 'c') {
                    // Remove the "abc" sequence from the stack
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        
        // If the stack is empty, all characters formed valid "abc" sequences
        return stack.isEmpty();
    }
}
