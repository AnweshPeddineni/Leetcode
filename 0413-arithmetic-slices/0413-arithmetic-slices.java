class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length, count = 0;

        for (int i = 0; i < n - 2; i++) {
            int diff = nums[i + 1] - nums[i];

            for (int j = i + 2; j < n; j++) {
                if (nums[j] - nums[j - 1] == diff) {
                    count++; // ✅ Count arithmetic subarray
                } else {
                    break; // ✅ Break if the sequence is broken
                }
            }
        }

        return count;
    }
}
