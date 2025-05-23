public class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Initialize count of subarrays, prefix sum, and hash map for remainders
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // To handle subarrays that start from the beginning

        for (int num : nums) {
            // Update prefix sum
            prefixSum += num;
            
            // Calculate the remainder of the prefix sum divided by k
            int mod = Math.abs(prefixSum % k);
            
            // // Adjust negative remainders to be positive
            // if (mod < 0) {
            //     mod += k;
            // }
            
            // If this remainder has been seen before, it means there are subarrays ending here that are divisible by k
            if (prefixMap.containsKey(mod)) {
                count += prefixMap.get(mod);
                prefixMap.put(mod, prefixMap.get(mod) + 1);
            } else {
                prefixMap.put(mod, 1);
            }
        }
        
        return count; // Total number of subarrays divisible by k
    }
}

           
// Input: nums = [4,5,0,-2,-3,1], k = 5
//     prefSum = [0,4,9, 9, 7,4]

// map = {remainder when doing (pref%k) : count}
//      {0 : 1,
//       4 : 1 +1 +1 +1,
//       2 : 1}

//       count = 3 
// 