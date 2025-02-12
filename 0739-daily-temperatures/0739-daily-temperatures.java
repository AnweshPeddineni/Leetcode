class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int[] result = new int[temperatures.length];
        
        for(int currentDay = 0; currentDay < temperatures.length; currentDay++){
            
            int currentTemp = temperatures[currentDay];
            
            while(!stack.isEmpty() && currentTemp > temperatures[stack.peek()]){
                int previousDay = stack.pop();
                result[previousDay] = currentDay - previousDay;
            }
            
            stack.push(currentDay);
        }
        
        return result;
        
    }
}