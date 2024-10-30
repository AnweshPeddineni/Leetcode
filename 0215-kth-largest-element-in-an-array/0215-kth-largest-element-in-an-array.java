
//    nums = [3,2,3,1,2,4,5,5,6], k = 4
       
//    minHeap = [1, 2, 3, 3]   current kthlargest = 3;

//    poll and add     [2, 3, 3, 4] 
             
//                     [3, 3, 4, 5]
                    
//                     [3, 4, 5, 5]
                     
//                     [4, 5, 5, 6]   kthlargest = 4;  nlog(k)



//    maxHeap = [6, 5, 5, 4, 3, 3, 2, 1]    pop 4 times kthlargest = 4; nlog(n)
   


class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);
        
        for(int i=0; i<nums.length; i++){
            
            minHeap.add(nums[i]);
            
            if(minHeap.size() > k){
                minHeap.poll();
            }
              
        }
        
        return minHeap.poll();
    }
}