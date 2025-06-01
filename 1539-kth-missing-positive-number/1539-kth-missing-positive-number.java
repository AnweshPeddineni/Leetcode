class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        // Binary search for smallest index where missing count >= k
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int missing = arr[mid] - (mid + 1);  // how many missing up to this point

            if (missing < k) {
                left = mid + 1;  // need to search right
            } else {
                right = mid - 1; // search left
            }
        }

        // After loop, left is the position where kth missing fits
        return left + k;
    }
}


//                l    m   r
// Input: arr = [2,3,4,7,11], k = 5