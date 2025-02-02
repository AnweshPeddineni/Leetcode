class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(String str : strs){

            char[] strArray = str.toCharArray();

            Arrays.sort(strArray);

            String key = new String(strArray);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                ArrayList<String> group = new ArrayList<>();
                map.put(key, group);
                map.get(key).add(str);
            }

        }

        for(ArrayList<String> group : map.values()){
            result.add(group);
        }

        return result;
    }
}