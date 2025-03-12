class Solution {
    public long maxWeight(int[] pizzas) {
        
        Arrays.sort(pizzas);

        int left = 0;
        int right = pizzas.length-1;

        int totalWeight = 0;

        int day = 1;
      
        int totalDays = pizzas.length/4;

        while(left < right){
            if(day%2 != 0){
               totalWeight += pizzas[right];
               right = right-1;
               left = left+3;
               day++;
            }else{
               right = right-1;
               totalWeight += pizzas[right];
               right = right-1;
               left = left+2;
               day++;
            }
        }

        return totalWeight;
    }
}