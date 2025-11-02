class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;
        if (m == 0 || n == 0 || k == 0) return res;

        // min-heap by sum: {sum, i, j}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // seed the first element of up to k rows
        int rows = Math.min(m, k);
        for (int i = 0; i < rows; i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[1], j = cur[2];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < n) {
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return res;
    }
}


// Core idea (row-seeded min-heap)

// Both arrays are sorted. For a fixed i (row in nums1), the pairs (nums1[i], nums2[j]) have sums that increase as j increases.
// So, for each row i, the smallest pair is with j=0. We:

// Seed the heap with the first pair from up to min(m, k) rows: push (i, 0) with priority nums1[i] + nums2[0].

// Repeat up to k times:

// Pop the smallest-sum (i, j) → output [nums1[i], nums2[j]].

// Push the next pair in the same row: (i, j+1) (if it exists).

// This enumerates pairs by increasing sum without ever pushing duplicates or exploring all m·n pairs.

// Why no visited set? We only ever move right within a row (i, 0) → (i, 1) → (i, 2) …, never from another path to the same (i, j). So each state is created once.
