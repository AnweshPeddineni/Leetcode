//Keep updating minPrice and based on minPrice keep updating maxProfit

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Update minPrice to the lowest price encountered so far
            minPrice = Math.min(minPrice, prices[i]);
            
            // Calculate the profit if sold on day i
            int profit = prices[i] - minPrice;
            
            // Update maxProfit if this profit is the highest seen so far
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
