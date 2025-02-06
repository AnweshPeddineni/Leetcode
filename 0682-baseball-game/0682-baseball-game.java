class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            if(operations[i].equals("+")) {
                int a = st.pop();
                int b = st.peek();
                st.push(a);
                st.push(a + b);
            }
            else if(operations[i].equals("C")) {
                st.pop();  
            }
            else if(operations[i].equals("D")) {
                int a = st.peek();
                st.push(a * 2);
            }
            else {
                int a = Integer.parseInt(operations[i]);
                st.push(a);
            }
        }
        
        int sum = 0;
        while(!st.isEmpty()) {   
            sum += st.pop();
        }
        return sum;
    }
}