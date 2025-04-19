class Solution {
    public int maximumCandies(int[] candies, long k) {
        long left = 1;
        long right = (long) 1e7;  // Max possible candy in any pile
        int result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canDivide(candies, k, mid)) {
                result = (int) mid;  // Mid is a valid answer
                left = mid + 1;      // Try to find a better (larger) answer
            } else {
                right = mid - 1;     // Too greedy, reduce
            }
        }

        return result;
    }

    // Helper to check if we can give "mid" candies to at least k children
    private boolean canDivide(int[] candies, long k, long mid) {
        long count = 0;

        for (int pile : candies) {
            count += (pile / mid);  // Each pile contributes how many children
            if (count >= k) return true;  // Early exit
        }

        return false;
    }
}

// candies = [1,8,13,16,18]
// k = 6