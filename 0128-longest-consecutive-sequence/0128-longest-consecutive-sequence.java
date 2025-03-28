class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        
        // Add all numbers to the set
        for (int num : nums) {
            set.add(num);
        }
        
        int maxSequenceLength = 0;
        
        // Iterate over the numbers
        for (int num : nums) {
            
            // Only start counting when num is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentSequenceLength = 1;
                
                // Keep incrementing and checking if the next number exists
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentSequenceLength += 1;
                }
                
                // Update the max sequence length
                maxSequenceLength = Math.max(maxSequenceLength, currentSequenceLength);
            }
        }
        
        return maxSequenceLength;
    }
}
