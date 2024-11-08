class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int position = nums.length - 1;
        
        while(left <= right){
            int leftSquare = nums[left]*nums[left];
            int rightSquare = nums[right]*nums[right];
            
            if(leftSquare >= rightSquare){
                result[position] = leftSquare;
                left++;
            }else{
                result[position] = rightSquare;
                right--;
            }
            position--;
        }
        
        return result;
        
    }
}