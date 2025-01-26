class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        // Count the occurrences of each element
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // Check if the current element is the majority element
            if (countMap.get(num) > n / 2) {
                return num;
            }
        }

        return -1; // This line will never be reached as per the problem statement
    }
}
