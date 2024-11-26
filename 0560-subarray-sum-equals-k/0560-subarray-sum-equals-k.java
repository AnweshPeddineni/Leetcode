

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0; // To store the total number of subarrays
        int curSum = 0; // Tracks the cumulative sum
        HashMap<Integer, Integer> prefixSums = new HashMap<>(); // To store prefix sums and their frequencies

        // Base case: A prefix sum of 0 is seen once at the beginning
        prefixSums.put(0, 1);

        // Traverse the array
        for (int n : nums) {
            curSum += n; // Update the cumulative sum

            // Calculate the difference between current sum and target (k)
            int diff = curSum - k;

            // Check if this difference exists in the map
            // If it exists, it means there are subarrays ending at the current index with sum = k
            result += prefixSums.getOrDefault(diff, 0);

            // Update the frequency of the current prefix sum in the map
            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);
        }

        return result; // Return the total count of subarrays with sum = k
    }
}

// Key Idea
// Storing frequencies of prefix sums allows us to:

// Count Multiple Subarrays especially when there are negative numbers we might get same prefix sum multiple times:
// If a prefix sum occurs multiple times, each occurrence represents a potential subarray that ends at different indices and satisfies the condition.