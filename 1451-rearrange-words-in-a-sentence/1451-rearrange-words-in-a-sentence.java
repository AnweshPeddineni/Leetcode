class Solution {
    public String arrangeWords(String text) {
         // ✅ Step 1: Split the text into words
        String[] words = text.toLowerCase().split(" ");

        // ✅ Step 2: Sort the words by length using a custom comparator
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // ✅ Step 3: Join the sorted words and format the result
        String result = String.join(" ", words);

        // ✅ Step 4: Capitalize the first letter and return the result
        return result.substring(0, 1).toUpperCase() + result.substring(1);
    }
}