class Solution {
    public boolean isMonotonic(int[] nums) {
        
        return isNonDecreasing(nums) || isDecreasing(nums);
    }

    public boolean isNonDecreasing(int[] nums){

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }

        return true;
    }

    public boolean isDecreasing(int[] nums){

        for(int i=0; i<nums.length-1; i++){
            if(nums[i] < nums[i+1]){
                return false;
            }
        }

        return true;
    }
}