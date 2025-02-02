class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> windowSet = new HashSet<>();
        int left = 0;
        int right = 0;

        int maxSize = 0;
        int currSize = 0;


        while(right < s.length()){
            if(!windowSet.contains(s.charAt(right))){
                windowSet.add(s.charAt(right));
                currSize = right-left+1;
                maxSize = Math.max(maxSize, currSize);
                right++;
            }else{
                windowSet.remove(s.charAt(left));
                left++;
            }
        }
        return maxSize;
    }
}