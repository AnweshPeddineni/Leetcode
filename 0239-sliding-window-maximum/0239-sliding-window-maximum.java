import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // To store the max values
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); 
        // maxHeap stores {value, index}

        for (int i = 0; i < n; i++) {
            // Add current element to the heap
            maxHeap.offer(new int[]{nums[i], i});

            // Remove elements that are out of the current window
            while (maxHeap.peek()[1] < i - k + 1) {
                maxHeap.poll();
            }

            // Start recording results once the first window is complete
            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek()[0];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [3, 3, 5, 5, 6, 7]
    }
}
