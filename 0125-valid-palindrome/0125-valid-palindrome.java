class Solution {
    public boolean isPalindrome(String s) {
        // Step 1: Clean the string
        String cleanedString = cleanString(s);

        // Step 2: Use the two-pointer technique to check if the cleaned string is a palindrome
        int left = 0;
        int right = cleanedString.length() - 1;

        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Helper method to clean the string by removing non-alphanumeric characters
    private String cleanString(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }
}
