class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Map to store fruit type and its count
        int left = 0; // Sliding window left pointer
        int maxFruits = 0; // Maximum fruits collected

        for (int right = 0; right < fruits.length; right++) {
            // Add the current fruit to the map and increment its count
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // If there are more than 2 types of fruits, shrink the window
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1); // Decrease count of the leftmost fruit
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]); // Remove fruit type if its count is 0
                }
                left++; // Shrink the window
            }

            // Update the maximum number of fruits collected
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits; // Return the maximum number of fruits collected
    }
}
