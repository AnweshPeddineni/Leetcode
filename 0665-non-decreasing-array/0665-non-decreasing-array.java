class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0; // Count of modifications

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) { // Found a decreasing pair
                count++;
                if (count > 1) return false; // More than one modification needed

                // Modify nums[i] if possible
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];  // Modify nums[i] down
                } else {
                    nums[i + 1] = nums[i];  // Modify nums[i+1] up
                }
            }
        }

        return true; // At most one modification was made
    }
}

// [5,3,4,7]


// [5,4,4,4,7]