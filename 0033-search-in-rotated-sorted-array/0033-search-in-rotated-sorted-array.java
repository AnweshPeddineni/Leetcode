class Solution {
    public int search(int[] nums, int target) {
       
        int l = 0;
        int r = nums.length - 1;
        
        
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid; // Target found
            }

            // Determine if the left half of the array is sorted
            if (nums[l] <= nums[mid]) {
                // If target is within the range of the left sorted half, narrow the search to the left
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    // Otherwise, search in the right half
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    // Otherwise, search in the left half
                    r = mid - 1;
                }
            }
        }
        
        // Target not found in the array
        return -1;
    }
}