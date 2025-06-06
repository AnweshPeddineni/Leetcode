class Solution {
    public int splitArray(int[] nums, int k) {
        
        // **I will set the lower bound to the max element**
        // Because we must at least include the largest element in any subarray
        int left = Arrays.stream(nums).max().getAsInt();

        // **I will set the upper bound to the sum of all elements**
        // This is the case when we put everything in one subarray
        int right = Arrays.stream(nums).sum();

        // **I will binary search to find the smallest possible max sum**
        while (left < right) {
            int mid = left + (right - left) / 2;

            // **If I can split with max subarray sum ≤ mid in ≤ k parts**
            if (canSplit(nums, mid, k)) {
                // Try smaller max sum
                right = mid;
            } else {
                // Need larger subarray sum
                left = mid + 1;
            }
        }

        return left; // or right (both will be same)
    }

    // **Check if I can split nums into ≤ k subarrays with each sum ≤ maxSumAllowed**
    private boolean canSplit(int[] nums, int maxSumAllowed, int k) {
        int currentSum = 0;
        int parts = 1;

        for (int num : nums) {
            // **If adding this number exceeds allowed sum, I will start a new subarray**
            if (currentSum + num > maxSumAllowed) {
                parts++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        // **Return true if number of parts used is within limit**
        return parts <= k;
    }
}
