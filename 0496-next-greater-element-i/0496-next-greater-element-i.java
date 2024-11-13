
// nums1 = [4,1,2], nums2 = [1,3,4,2]

// result = [0,0,0]

// stack =     -1]
         



class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        
        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];
            
            // Pop elements from the stack that are smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= current) {
                stack.pop();
            }
            
            // If stack is not empty, the top element is the next greater element
            if (!stack.isEmpty()) {
                map.put(current, stack.peek());
            } else {
                map.put(current, -1);
            }
            
            // Push the current element onto the stack
            stack.push(current);
        }
        
        // Fill the result array based on nums1 using the map
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        
        return result;
    }
}
