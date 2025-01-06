class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        List<List<String>> result = new ArrayList<>();

        for(int i=0; i<strs.length; i++){

           char[] sortedChars = strs[i].toCharArray();
           Arrays.sort(sortedChars);
           String key = new String(sortedChars);

           ArrayList<String> group = map.getOrDefault(key, new ArrayList<>());
           group.add(strs[i]);
           map.put(key, group);
        }


        for( ArrayList<String> list : map.values()){
           result.add(list);
        }

        return result;
    }
}