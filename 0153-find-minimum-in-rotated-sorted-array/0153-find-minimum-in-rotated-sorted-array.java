class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length-1;
    
        int mid = (left+right)/2;
        
        while(left <= right){
            
            mid = (left + right)/2;
            
            if(nums[mid] > nums[right]){
               left = mid + 1;
            }else if(nums[mid] == nums[right]){
                return nums[left];
            }else{
               right = mid;
            } 
        }
        
        return nums[left];
           
    }
}