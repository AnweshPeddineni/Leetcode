class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int currDay = 0; currDay < n; currDay++) {
            
            int currentTemp = temperatures[currDay];
            
            while(!stack.isEmpty() && currentTemp > temperatures[stack.peek()]){
                
                int prevDay = stack.pop();
                answer[prevDay] = currDay-prevDay;
            }
            
            stack.push(currDay);
        }
        
        return answer;
    }
}