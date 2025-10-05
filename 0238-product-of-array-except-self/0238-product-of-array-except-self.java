class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] prefixProd = new int[nums.length];
        int[] suffixProd = new int[nums.length];

        int pref = 1;
        prefixProd[0] = pref;
        for(int i=1; i<nums.length; i++){
            pref *= nums[i-1];
            prefixProd[i] = pref;
        }
        
        int suff = 1;
        suffixProd[nums.length-1] = suff;
        for(int i=nums.length-2; i>=0; i--){
            suff *= nums[i+1];
            suffixProd[i] = suff;
        }

        int[] result = new int[nums.length];

        for(int i=0; i<result.length; i++){
            result[i] = prefixProd[i]*suffixProd[i];
        }

        return result;
    }
}