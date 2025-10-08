class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // TO DO: correct the syntax
        Stack<int[]> stack = new Stack<>();

        int[] result = new int[temperatures.length];


        for(int i=0; i<temperatures.length; i++){
              if(stack.isEmpty()){
                stack.push(new int[] {i,temperatures[i]});
              }else{
                 while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]){
                     result[stack.peek()[0]] = i-stack.peek()[0];
                     stack.pop();
                 }
                 stack.push(new int[] {i,temperatures[i]});
              }
        }

        return result;
    }
}