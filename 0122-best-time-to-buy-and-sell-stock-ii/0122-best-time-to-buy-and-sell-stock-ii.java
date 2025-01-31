class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;

        int netProfit = 0;
     

        for(int sell = 1; sell<prices.length; sell++){

            if(prices[sell] <= prices[buy]){
                buy = sell;
            }else{
                int currentProfit = prices[sell] - prices[buy];
                buy = sell;
                netProfit += currentProfit;
            }
        }

        return netProfit;
    }
}