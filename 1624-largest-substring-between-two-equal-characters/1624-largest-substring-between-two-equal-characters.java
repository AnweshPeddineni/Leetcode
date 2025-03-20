class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        int[] firstIndex = new int[26]; 
        
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1; 
        }
        
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            
            if (firstIndex[charIndex] == -1) {
                firstIndex[charIndex] = i; 
            } else {
                maxLength = Math.max(maxLength, i - firstIndex[charIndex] - 1);
            }
        }
        
        return maxLength;
    }
}
//             i
// Input: s = "abcaxdzca"
//                j