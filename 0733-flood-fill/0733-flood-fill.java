

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int R = image.length, C = image[0].length;
        int before = image[sr][sc];
        if (before == color) return image; // nothing to do

        ArrayDeque<int[]> q = new ArrayDeque<>();
        image[sr][sc] = color; // mark as visited by recoloring
        q.offer(new int[]{sr, sc});
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && image[nr][nc] == before) {
                    image[nr][nc] = color;   // visit & recolor
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return image;
    }
}
