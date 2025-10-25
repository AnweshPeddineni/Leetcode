class Solution {
    public int search(int[] nums, int target) {
        //step1 - finding pivot
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        //step-2 finding in which of the sorted array should I search
        int start = left;
        left = 0;
        right = nums.length - 1;
        
        if(nums[start] <= target && nums[right] >= target){
            left = start;
        } else{
            right = start;
        }
        
        //Step-3
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}