class Solution {

    // \U0001f7e2 I will use dfs(index, prevIndex) to represent LIS length starting at `index` given last picked index `prevIndex`
    // \U0001f7e2 I will use a 2D memo table memo[index][prevIndex + 1] to cache results (-1 means not computed)
    // \U0001f7e2 I will at each step choose the max between skipping nums[index] or taking it (if it forms a strictly increasing sequence)
    private int[][] memo;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, -1, nums);
    }

    private int dfs(int index, int prevIndex, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        int memoKey = prevIndex + 1;
        if (memo[index][memoKey] != -1) {
            return memo[index][memoKey];
        }

        // \U0001f7e2 I will compute the option of skipping the current element
        int skip = dfs(index + 1, prevIndex, nums);

        int take = 0;
        // \U0001f7e2 I will compute the option of taking the current element if it keeps sequence strictly increasing
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + dfs(index + 1, index, nums);
        }

        // \U0001f7e2 I will store and return the best of taking or skipping
        int best = Math.max(take, skip);
        memo[index][memoKey] = best;
        return best;
    }
}


// Time: O(n^2) (states n*(n+1); each computes O(1)).
// Space: O(n^2) for memo + O(n) recursion stack.