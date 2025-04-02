class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        Deque<Integer> minQueue = new LinkedList<>(); //to save the smallest in the front
        Deque<Integer> maxQueue = new LinkedList<>(); //to save the largest in the front

        int left = 0;
        int right = 0;

        int maxSize = 0;

        while(right < nums.length){
            while(!minQueue.isEmpty() && minQueue.peekLast() > nums[right]){
                minQueue.pollLast();
            }
            minQueue.offerLast(nums[right]);

            while(!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]){
                maxQueue.pollLast();
            }
            maxQueue.offerLast(nums[right]);

            
            while(maxQueue.peekFirst() - minQueue.peekFirst() > limit){
                if(maxQueue.peekFirst() == nums[left]){
                   maxQueue.pollFirst();
                }

                if(minQueue.peekFirst() == nums[left]){
                   minQueue.pollFirst();
                }

                left++;
            }

            int currSize = right-left+1;

            maxSize = Math.max(maxSize, currSize);

            right++;
        }

        return maxSize;

    }
}