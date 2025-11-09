class Solution {
    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];

        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);

        if(set.contains(c)) return c;
        if(set.contains(d)) return d;

        return -1;
    }
}

// Undirected graph

//Input: edges = [[1,2],[2,3],[4,2]]
// Output: 2