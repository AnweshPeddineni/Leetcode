class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProf = 0; 
        int left = 0;  
        
        for(int right=1; right<prices.length; right++){
            
           if(prices[right] < prices[left]){
               left = right;
           }
           
           int currProf = prices[right] - prices[left];
           if(currProf > maxProf){
               maxProf = currProf;
           }
        }
        return maxProf;
    }
}