import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort the array
        int left = 0; // Pointer to the lightest person
        int right = people.length - 1; // Pointer to the heaviest person
        int boats = 0; // Counter for boats

        while (left <= right) {
            // If the lightest and heaviest can share a boat
            if (people[left] + people[right] <= limit) {
                left++; // Move left pointer inward
            }
            // Heaviest person always goes in a boat
            right--; // Move right pointer inward
            boats++; // Increment the boat count
        }

        return boats;
    }
}
