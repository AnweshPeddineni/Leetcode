class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int[] pMap = new int[256];

        for(char c : p.toCharArray()){
            pMap[c]++;
        }

        int l = 0;
        int r = 0;

        int[] sSubMap = new int[256];

        while(r<s.length()){
            char rChar = s.charAt(r);
            sSubMap[rChar]++;

            if(Arrays.equals(sSubMap, pMap)){
                result.add(l);
            }
            
            while(r-l+1 > p.length()){
               char lChar = s.charAt(l);
               sSubMap[lChar]--;
               l++;
               if(Arrays.equals(sSubMap, pMap)){
                result.add(l);
               }
            }

            r++;
        }

        return result;
        
    }
}

//               l
// Input: s = "abab", p = "ab"
//                r

//              sSubMap = {a,b}
