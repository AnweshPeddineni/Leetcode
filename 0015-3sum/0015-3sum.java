class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // Input: nums = [-1,0,1,2,-1,-4]
        //            i 
        // sorted = [-4,-1,-1,0,1,2]
        //               j       
        //                        k

        // Output: [[-1,-1,2],[-1,0,1]]

        Arrays.sort(nums);

        HashSet<List<Integer>> result = new HashSet<>();
 
        for(int i=0; i<nums.length-2; i++){
           int j = i+1;
           int k = nums.length-1;
         
           while(j<k){
                // if(nums[k-1] == nums[k]){
                //     k--;
                // }
                // if(nums[j+1] == nums[j]){
                //     j++;
                // }

                if(nums[j] + nums[k] + nums[i] == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if(nums[j] + nums[k] + nums[i] > 0){
                    k--;
                }else{
                    j++;
                }   
           }

        }

        ArrayList<List<Integer>> resList = new ArrayList<>(result);

        return resList;
        
    }
}