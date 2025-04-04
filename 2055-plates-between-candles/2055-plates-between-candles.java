class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefixPlates = new int[n];  // prefix sum of plates
        int[] nearestLeftCandle = new int[n];
        int[] nearestRightCandle = new int[n];
        int plateCount = 0;

        // Step 1: Build prefix sum for number of plates up to each index
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                plateCount++;
            }
            prefixPlates[i] = plateCount;
        }

        // Step 2: Build nearestLeftCandle array
        int leftCandle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                leftCandle = i;
            }
            nearestLeftCandle[i] = leftCandle;
        }

        // Step 3: Build nearestRightCandle array
        int rightCandle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                rightCandle = i;
            }
            nearestRightCandle[i] = rightCandle;
        }

        // Step 4: Process queries using the above precomputed arrays
        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int left = queries[q][0];
            int right = queries[q][1];

            int start = nearestRightCandle[left];   // First candle on or after left
            int end = nearestLeftCandle[right];     // Last candle on or before right

            if (start != -1 && end != -1 && start < end) {
                result[q] = prefixPlates[end] - prefixPlates[start];
            } else {
                result[q] = 0; // no valid candle boundaries
            }
        }

        return result;
    }
}
