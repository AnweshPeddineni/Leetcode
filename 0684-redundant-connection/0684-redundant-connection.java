class Solution {
    private int[] parent, rank;

    // Returns the redundant edge that forms a cycle (LeetCode 684).
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;              // nodes are labeled 1..n
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i; // each node is its own parent

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (!union(u, v)) return e;    // already connected -> adding e makes a cycle
        }
        return new int[]{-1, -1};
    }

    // Finds the representative (root) of x; flattens the tree (path compression).
    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    // Unites sets of x and y by rank; returns false if x and y are already in same set.
    private boolean union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return false;        // same set -> cycle
        if (rank[rx] < rank[ry]) {
            parent[rx] = ry;
        } else if (rank[rx] > rank[ry]) {
            parent[ry] = rx;
        } else {
            parent[ry] = rx;
            rank[rx]++;                    // increase rank when merging equal-height trees
        }
        return true;
    }
}
