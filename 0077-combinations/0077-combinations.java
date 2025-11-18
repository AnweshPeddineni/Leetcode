

class Solution {
    /**
     * Generates all possible combinations of k numbers chosen from the range [1, n].
     *
     * @param n The upper bound of the range of numbers.
     * @param k The size of each combination.
     * @return A list of all possible combinations.
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allCombinations = new ArrayList<>(); // To store all valid combinations
        List<Integer> currentCombination = new ArrayList<>(); // To store the current combination being built
        generateCombinations(1, n, k, currentCombination, allCombinations); // Start from number 1
        return allCombinations;
    }

    /**
     * Helper method to perform backtracking and generate combinations.
     *
     * @param start The starting number for the current recursion.
     * @param n The upper bound of the range of numbers.
     * @param k The number of elements to choose.
     * @param current The current combination being built.
     * @param allCombinations The list to store all valid combinations.
     */
    private void generateCombinations(int start, int n, int k, List<Integer> current, List<List<Integer>> allCombinations) {
        // Base case: If the current combination has reached the desired size, add it to the result list
        if (current.size() == k) {
            allCombinations.add(new ArrayList<>(current)); // Make a deep copy to avoid reference issues
            return;
        }

        // Iterate through the possible candidates for the next element in the combination
        for (int number = start; number <= n; number++) {
            current.add(number); // Choose the current number
            generateCombinations(number + 1, n, k, current, allCombinations); // Recurse with the next number
            current.remove(current.size() - 1); // Backtrack: remove the last added number to explore new possibilities
        }
    }
}
