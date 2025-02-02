class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prefixArray = new int[nums.length];
        int[] suffixArray = new int[nums.length];
        
        int start = 1;
        
        prefixArray[0] = start;
        for(int i=1; i<prefixArray.length; i++){
            prefixArray[i] = nums[i-1]*prefixArray[i-1];
        }
        
        suffixArray[suffixArray.length-1] = start;
        for(int i=suffixArray.length-2; i>=0; i--){
            suffixArray[i] = nums[i+1]* suffixArray[i+1];
        }
        
        int[] result = new int[nums.length];
        
        for(int i=0; i<result.length; i++){
            result[i] = prefixArray[i]*suffixArray[i];
        }
        
        return result;
    }
}