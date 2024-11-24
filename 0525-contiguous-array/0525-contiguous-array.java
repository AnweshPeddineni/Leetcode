
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int balance = 0;

        // Initialize the map with balance 0 at index -1
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            // Update balance: +1 for 1, -1 for 0
            if(nums[i] == 0){
                balance += -1;
            }else{
                balance += 1;
            }

            if (map.containsKey(balance)) {
                // If the balance has been seen before, calculate the subarray length
                maxLength = Math.max(maxLength, i - map.get(balance));
            } else {
                // Store the first occurrence of this balance
                map.put(balance, i);
            }
        }

        return maxLength;
    }
}
