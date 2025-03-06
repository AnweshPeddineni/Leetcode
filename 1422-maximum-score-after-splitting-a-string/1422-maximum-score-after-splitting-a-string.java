class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        int leftZeros = 0;
        int maxScore = Integer.MIN_VALUE;

        // ✅ Count total number of '1's in the entire string
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        // ✅ Iterate through possible split points (ignoring the last index)
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                totalOnes--;  // Right substring loses a '1'
            }

            // ✅ Compute score: leftZeros + remaining ones in right part
            int score = leftZeros + totalOnes;
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}
