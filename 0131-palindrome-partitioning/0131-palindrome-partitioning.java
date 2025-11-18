
class Solution {

    // \U0001f7e2 I will return all possible palindrome partitionings of the given string.
    // \U0001f7e2 I will use backtracking to explore all partitions and choose only palindromic substrings.
    // \U0001f7e2 I will store one current partition path and add it to the result when I reach the end.
    public List<List<String>> partition(String s) {
        // \U0001f7e2 I will create the final result list of all palindrome partitions.
        List<List<String>> result = new ArrayList<>();
        // \U0001f7e2 I will keep track of the current list of substrings in this path.
        List<String> current = new ArrayList<>();
        // \U0001f7e2 I will start backtracking from index 0 of the string.
        backtrack(s, 0, current, result);
        // \U0001f7e2 I will return the filled result containing all valid partitions.
        return result;
    }

    // \U0001f7e2 I will backtrack from a given start index and collect palindromic substrings.
    // \U0001f7e2 I will add the current path to result when start reaches the end of the string.
    private void backtrack(String s,
                           int startIndex,
                           List<String> current,
                           List<List<String>> result) {
        // \U0001f7e2 I will check if I have consumed the entire string.
        if (startIndex == s.length()) {
            // \U0001f7e2 I will add a copy of the current partition to the result list.
            result.add(new ArrayList<>(current));
            // \U0001f7e2 I will return because there are no more characters to partition.
            return;
        }

        // \U0001f7e2 I will try all possible end indices starting from startIndex.
        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            // \U0001f7e2 I will check if substring s[startIndex..endIndex] is a palindrome.
            if (isPalindrome(s, startIndex, endIndex)) {
                // \U0001f7e2 I will add this palindromic substring to the current path.
                current.add(s.substring(startIndex, endIndex + 1));
                // \U0001f7e2 I will recurse from endIndex + 1 to process the remaining part of the string.
                backtrack(s, endIndex + 1, current, result);
                // \U0001f7e2 I will remove the last added substring to backtrack and try another cut.
                current.remove(current.size() - 1);
            }
        }
    }

    // \U0001f7e2 I will check if the substring s[left..right] is a palindrome using two pointers.
    // \U0001f7e2 I will move pointers towards the center while characters are equal.
    private boolean isPalindrome(String s, int left, int right) {
        // \U0001f7e2 I will compare characters from both ends until the pointers cross.
        while (left < right) {
            // \U0001f7e2 I will return false immediately if a mismatch is found.
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            // \U0001f7e2 I will move the left pointer one step to the right.
            left++;
            // \U0001f7e2 I will move the right pointer one step to the left.
            right--;
        }
        // \U0001f7e2 I will return true if all corresponding characters matched.
        return true;
    }
}


// Time O(n^2 * 2^n) and Space Complexity (Optimal)

// Time Complexity: In the worst case (like s = "aaaa..."), there are many palindrome partitions; exploring all of them with checks yields about O(n^2 * 2^n) time (palindrome checks inside an exponential number of partition paths).

// Space Complexity: O(n) for recursion depth and current path (in the longest case, n single-character substrings), plus O(TotalOutputSize) to store all partitions.