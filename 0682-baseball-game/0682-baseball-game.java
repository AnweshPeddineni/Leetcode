class Solution {
    public int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>();

        int scoresSum = 0;

        for(int i=0; i<operations.length; i++){

            if(operations[i].equals("+")){
               String prevOne = stack.pop();
               String prevTwo = stack.pop();
               int result = Integer.parseInt(prevOne)+Integer.parseInt(prevTwo);
               String resultStr = Integer.toString(result);
               stack.push(prevTwo);
               stack.push(prevOne);
               stack.push(resultStr);

            }else if(operations[i].equals("D")){
               String prevOne = stack.peek();
               int result = Integer.parseInt(prevOne)*2;
               String resultStr = Integer.toString(result);
               stack.push(resultStr);

            }else if(operations[i].equals("C")){
               stack.pop();
            }else{
               stack.add(operations[i]);
            }
            
        }

        

        while(!stack.isEmpty()){
            scoresSum += Integer.parseInt(stack.pop());
        }

        return scoresSum;

    }
}