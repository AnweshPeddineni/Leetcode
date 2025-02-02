import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;

        // Shrink the window from both sides until its size is k
        while (right - left + 1 > k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;  // Move left pointer right
            } else {
                right--; // Move right pointer left
            }
        }

        // Convert the final window into a list and return
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
