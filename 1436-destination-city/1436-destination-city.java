class Solution {
    public String destCity(List<List<String>> paths) {
        
        Map<String, String> map = new HashMap<>();

        String result = "";

        for(List<String> path : paths){
           map.put(path.get(0), path.get(1));
        }
        
        String key = paths.get(0).get(0);
        
        while(true){
          String destination = map.get(key);

           if(map.containsKey(destination)){
               key = destination;
           }else{
               result = destination;
               break;
           }
        }
        
       return result;

    }
}