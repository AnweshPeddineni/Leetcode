import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int goodPairs = 0;

        for (int num : nums) {
            // **If num has appeared before, it can form goodPairs with its previous occurrences**
            if (freqMap.containsKey(num)) {
                goodPairs += freqMap.get(num); // **Each previous occurrence forms a pair**
            }

            // **Increment count of num in the HashMap**
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        return goodPairs;
    }
}
