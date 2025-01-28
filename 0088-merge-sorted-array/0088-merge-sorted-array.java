class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;       // Pointer for nums1
        int p2 = n - 1;       // Pointer for nums2
        int p = m + n - 1;    // Pointer for placement in nums1

        // Merge nums1 and nums2 starting from the end
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1]; // Place larger element
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--; // Move placement pointer backward
        }

        // If there are remaining elements in nums2, copy them
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
