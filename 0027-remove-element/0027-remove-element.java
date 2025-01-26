class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0; // Pointer to track position for the next valid element

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right]; // Place valid element at left pointer
                left++; // Move left pointer
            }
        }

        return left; // Number of valid elements
    }
}
