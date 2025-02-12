import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false; // ✅ If lengths mismatch, return false
        }

        for (int i = 0; i < pattern.length(); i++) {
            char currChar = pattern.charAt(i);
            String currWord = words[i];

            // ✅ If char is already mapped, check if it maps to the same word
            if (charToWord.containsKey(currChar)) {
                if (!charToWord.get(currChar).equals(currWord)) {
                    return false;
                }
            } else {
                charToWord.put(currChar, currWord);
            }

            // ✅ If word is already mapped, check if it maps to the same char
            if (wordToChar.containsKey(currWord)) {
                if (wordToChar.get(currWord) != currChar) {
                    return false;
                }
            } else {
                wordToChar.put(currWord, currChar);
            }
        }

        return true;
    }
}
