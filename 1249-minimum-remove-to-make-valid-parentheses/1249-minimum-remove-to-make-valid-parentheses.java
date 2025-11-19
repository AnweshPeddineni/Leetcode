class Solution {

    // \U0001f7e2 I will remove the minimum number of parentheses to make the string valid.
    // \U0001f7e2 I will use a stack to track indices of '(' that are not yet matched.
    // \U0001f7e2 I will mark unmatched '(' and ')' as invalid using a boolean array and skip them when building the result.
    public String minRemoveToMakeValid(String s) {
        // \U0001f7e2 I will convert the string length into a variable for easy use.
        int n = s.length();
        // \U0001f7e2 I will use this stack to store indices of '(' characters.
        Stack<Integer> stack = new Stack<>();
        // \U0001f7e2 I will use this array to mark indices that should be removed.
        boolean[] invalid = new boolean[n];

        // \U0001f7e2 I will traverse each character in the string once.
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            // \U0001f7e2 I will push index of '(' onto the stack to find its matching ')'.
            if (ch == '(') {
                stack.push(i);
            } 
            // \U0001f7e2 I will try to match ')' with the most recent '(' from the stack.
            else if (ch == ')') {
                // \U0001f7e2 If there is no '(' to match, this ')' is invalid and will be marked.
                if (stack.isEmpty()) {
                    invalid[i] = true;
                } else {
                    // \U0001f7e2 If there is a '(', I will pop it and treat this pair as matched.
                    stack.pop();
                }
            }
            // \U0001f7e2 For lowercase letters, I will do nothing here because they are always valid.
        }

        // \U0001f7e2 Any indices left in the stack are unmatched '(' and must be removed.
        while (!stack.isEmpty()) {
            int index = stack.pop();
            invalid[index] = true;
        }

        // \U0001f7e2 I will build the final valid string by skipping all invalid indices.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // \U0001f7e2 I will append only characters that are not marked invalid.
            if (!invalid[i]) {
                result.append(s.charAt(i));
            }
        }

        // \U0001f7e2 I will return the constructed valid parentheses string.
        return result.toString();
    }
}
