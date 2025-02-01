class Solution {
    public void rotate(int[] nums, int k) {

        if(nums.length < 2) return;

        Stack<Integer> stack = new Stack<>();
       
        int index = nums.length-1;

        while(index > nums.length-1-k){
            stack.push(nums[index]);
            index--;
        }

        for(int i=nums.length-1; i>=k; i--){
            nums[i] = nums[i-k];
        }

        for(int i=0; i<k; i++){
            nums[i] = stack.pop();
        }

    }
}