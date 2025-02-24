class Solution {
    public boolean search(int[] nums, int target) {
  
        int l = 0;
        int r = nums.length-1;

        int mid = 0;

        while(l <= r){
            
            mid = l+(r-l)/2;

            if(nums[mid] == target){
                return true;
            }

            while (l < r && nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            }
            
            if(nums[l] <= nums[mid]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(target > nums[mid] && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
            
        }

        return false;
        
    }
}