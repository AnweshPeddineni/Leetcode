class Solution {
    public List<List<Integer>> adjList = new ArrayList<>();

    public int[] gardenNoAdj(int n, int[][] paths) {
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<paths.length; i++){
            adjList.get(paths[i][0]).add(paths[i][1]);
            adjList.get(paths[i][1]).add(paths[i][0]);
        }

        int[] visOrColored = new int[n+1];

        for(int i=0; i<=n; i++){
            if(visOrColored[i] == 0){
                flowerIt(visOrColored, i);
            }
        }

        return Arrays.copyOfRange(visOrColored, 1, n+1);
    }

    public void flowerIt(int[] visOrColored, int node){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(node);
        visOrColored[node] = 1;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            int color = visOrColored[curr];

            for(int v : adjList.get(curr)){
                if(visOrColored[v] == 0 || visOrColored[v] == color){
                    visOrColored[v] = color == 4? 1 : color+1;
                    queue.add(v);
                }
            }
        }
    }
}