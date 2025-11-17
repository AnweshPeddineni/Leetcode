class Solution {
    // \U0001f7e2 I will use a memo array where memo[rem] stores the minimum coins needed for amount = rem
    // \U0001f7e2 I will use dfs(rem) to compute this, trying every coin and memoizing results to avoid recomputation
    // \U0001f7e2 I will return -1 from dfs(rem) when it is impossible to form that remaining amount
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2); // -2 means "not computed yet"
        return dfs(amount, coins, memo);
    }

    private int dfs(int remaining, int[] coins, int[] memo) {
        if (remaining == 0) return 0;
        if (remaining < 0) return -1;

        if (memo[remaining] != -2) {
            return memo[remaining];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            // \U0001f7e2 I will recursively try using this coin and see if the subproblem is solvable
            int sub = dfs(remaining - coin, coins, memo);
            if (sub >= 0 && sub < minCoins) {
                minCoins = sub + 1;
            }
        }

        // \U0001f7e2 I will store -1 if no combination worked, otherwise the found minimum coins
        memo[remaining] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[remaining];
    }
}

// Time Complexity: O(n * amount) where n is the number of coin types, because each rem   from 1 to amount is computed once and loops over all coins.

// Space Complexity: O(amount) for the memo array plus O(amount) recursion stack in the worst case.
