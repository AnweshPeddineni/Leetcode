class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;

        // ✅ Step 1: Use Cycle Sort to place numbers at correct indices
        while (i < n) {
            int correct = nums[i]; // Expected index for nums[i]
            if (nums[i] < n && nums[i] != nums[correct]) { 
                swap(nums, i, correct); // ✅ Swap to correct place
            } else {
                i++; // ✅ Move to next index
            }
        }

        // ✅ Step 2: Identify the missing number
        for (int j = 0; j < n; j++) {
            if (nums[j] != j) {
                return j; // ✅ Found the missing number
            }
        }

        return n; // ✅ If all numbers are correct, the missing number is `n`
    }

    // ✅ Swap helper function
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
