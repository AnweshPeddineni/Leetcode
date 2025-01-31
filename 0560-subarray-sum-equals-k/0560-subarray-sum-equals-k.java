import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // To handle cases where prefixSum itself equals k

        int currentSum = 0, result = 0;

        for (int num : nums) {
            currentSum += num;

            // Check how many times (currentSum - k) has appeared before
            if (prefixSumCount.containsKey(currentSum - k)) {
                result += prefixSumCount.get(currentSum - k);
            }

            // Store the prefix sum count
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return result;
    }
}
