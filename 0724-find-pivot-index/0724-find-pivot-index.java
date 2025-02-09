class Solution {
    public int pivotIndex(int[] nums) {

        int result = -1;
        
        int[] prefixSum = new int[nums.length];
        int[] suffixSum = new int[nums.length];
 
        int sum = 0;
        for(int i=1; i<nums.length; i++){
            prefixSum[i] = sum + nums[i-1];
            sum = prefixSum[i];
        }

        sum = 0;
        for(int i=nums.length-2; i>=0; i--){
           suffixSum[i] = sum + nums[i+1];
           sum = suffixSum[i];
        }
  
      
        // Find pivot index where prefixSum[i] == suffixSum[i]
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                return i; // Found pivot index
            }
        }
        
        return result;

    }
}