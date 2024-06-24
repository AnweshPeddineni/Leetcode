class Solution {
    public int trap(int[] height) {
        
        int ans = 0;
        int size = height.length;
        
        for (int i = 1; i < size - 1; i++) {
            int leftMax = 0, rightMax = 0;
            
            // Find the maximum height to the left of the current index
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            
            // Find the maximum height to the right of the current index
            for (int j = i + 1; j < size; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            
            // Calculate the trapped water if there is a boundary on both sides
            int minHeight = Math.min(leftMax, rightMax);
            if (minHeight > height[i]) {
                ans += minHeight - height[i];
            }
        }
        
        return ans;
    }
}
