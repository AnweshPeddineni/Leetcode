class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int ans = 0; // To store the maximum length of the common subarray
        int[][] dp = new int[nums1.length + 1][nums2.length + 1]; 
        // dp[i][j] represents the length of the longest common subarray starting at nums1[i] and nums2[j]
        
        // Traverse the arrays from the back to the front
        for (int i = nums1.length - 1; i >= 0; --i) { 
            for (int j = nums2.length - 1; j >= 0; --j) {
                // If the current elements of nums1 and nums2 are equal
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1; 
                    // Update dp[i][j] based on the next elements in both arrays
                }

                // Update the maximum length encountered so far
                if (ans < dp[i][j]) {
                    ans = dp[i][j];
                }
            }
        }

        return ans; // Return the maximum length of the common subarray
    }
}
