class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0, leftSum = 0;

        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Iterate through the array and check for pivot index
        for (int i = 0; i < nums.length; i++) {
            // If leftSum equals rightSum, return index
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }

            // Update leftSum for next iteration
            leftSum += nums[i];
        }

        return -1; // No pivot index found
    }
}
