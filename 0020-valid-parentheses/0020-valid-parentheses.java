class Solution {
    public boolean isValid(String s) {
        
        if(s.length() == 1) return false;
            
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else {
                if(stack.size() == 0 || stack.peek() != c){
                  return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}