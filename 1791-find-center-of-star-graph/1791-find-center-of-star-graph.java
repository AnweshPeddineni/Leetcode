class Solution {
    public int findCenter(int[][] edges) {
        
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<edges.length; i++){

            if(set.contains(edges[i][0])) return  edges[i][0];
            if(set.contains(edges[i][1])) return  edges[i][1];

            set.add(edges[i][0]);
            set.add(edges[i][1]);
        }

        return -1;
    }
}