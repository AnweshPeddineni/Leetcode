class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int curr : asteroids){

            while(!stack.isEmpty() && stack.peek() > 0 && curr < 0){
                int top = stack.peek();

                if (Math.abs(top) > Math.abs(curr)) { 
                    curr = 0; // Destroy `curr`, no need to add it
                } else if (Math.abs(top) == Math.abs(curr)) {
                    stack.pop(); // Destroy both
                    curr = 0;
                } else {
                    stack.pop(); // Destroy `top` and continue checking
                }

            }

            if (curr != 0) { // Only push surviving asteroids
               stack.push(curr);
            }
        }

        int[] result = new int[stack.size()];

        for(int i=0; i<stack.size(); i++){
            result[i] = stack.get(i);
        }

        return result;
    }
}
//              ->  <-  <-  <-   <-  <-  -> -> ->
// asteroids = [15, -5, -5, -5, -15, -3, 3, 2, -1]

// output = [-3, 3, 2]