class Solution {
    public int minCost(int[][] costs) {
        // Handle edge case where no houses are present
        if (costs == null || costs.length == 0) return 0;
        
        int n = costs.length;
        // Initialize memo as a HashMap with key as "house-lastColor" and value as min cost
        Map<String, Integer> memo = new HashMap<>();
        return minCostHelper(costs, 0, -1, memo);
    }

    private int minCostHelper(int[][] costs, int house, int prevColor, Map<String, Integer> memo) {
        // Base case: all houses have been painted
        if (house == costs.length) {
            return 0;
        }

        // Create a unique key for the current state
        String key = house + "-" + prevColor;

        // Check if the result is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minCost = Integer.MAX_VALUE;

        // Iterate through all possible colors for the current house
        for (int color = 0; color < 3; color++) {
            // Skip the color if it's the same as the previous house's color
            if (color == prevColor) continue;

            // Calculate the cost for painting the current house with the chosen color
            int currentCost = costs[house][color] + minCostHelper(costs, house + 1, color, memo);

            // Update the minimum cost found so far
            minCost = Math.min(minCost, currentCost);
        }

        // Store the computed minimum cost in the memoization map
        memo.put(key, minCost);
        return minCost;
    }
}
