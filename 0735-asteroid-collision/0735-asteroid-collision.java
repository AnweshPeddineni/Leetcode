class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

    // Process collisions only if the current asteroid is moving left and stack top is moving right
                //           bottom            top
          // For this stack = [-1, 10, 5, 4, 5, 6] new element is -10, this while loop will make the 
         // stack as [-1, -10]
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int top = stack.peek();

                if (Math.abs(asteroid) == Math.abs(top)) {
                    // Case 1: Both asteroids are equal in size, so both are destroyed
                    stack.pop();
                    destroyed = true;
                    break;
                } else if (Math.abs(asteroid) > Math.abs(top)) {
                    // Case 2: Current asteroid is larger, so the top of the stack is destroyed
                    stack.pop();
                } else {
                    // Case 3: Stack top asteroid is larger, so the current asteroid is destroyed
                    destroyed = true;
                    break;
                }
            }

            // If the current asteroid was not destroyed in a collision, push it onto the stack
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert the stack to an array in the correct order
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
