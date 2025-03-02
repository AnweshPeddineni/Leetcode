class Solution {
    public int pivotIndex(int[] nums) {

    int totalSum = 0;

    for(int num : nums){
        totalSum += num;
    }

    int leftSum = 0;


    for(int i=0; i<nums.length; i++){
        
        if(totalSum - leftSum - nums[i] == leftSum){
            return i;
        }

        leftSum += nums[i];
    }

    return -1;
        
    }
}

//                      i               
// Input: nums = [1,7,3,6,5,6]
//   prefixSum = [0,1,8,11]

//  
// return p

// totalSum = 28