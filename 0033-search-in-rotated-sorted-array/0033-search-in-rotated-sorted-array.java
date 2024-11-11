class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0;
        int right = nums.length - 1;
        
        // Step 1: Find the pivot (smallest element index)
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // Pivot is in the right half
                left = mid + 1;
            } else {
                // Pivot is in the left half (including mid)
                right = mid;
            }
        }
        
        int pivot = left;
        left = 0;
        right = nums.length - 1;
        
        // Step 2: Determine the search boundaries
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            right = pivot - 1;
        }
        
        // Step 3: Perform standard binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // Target not found
        return -1;
    }
}
