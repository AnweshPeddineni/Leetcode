class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        // Arrays.fill(colors, -1);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                colors[i] = 1;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int currentVal = queue.poll();
                    for (int n : graph[currentVal]) {
                        if (colors[n] == 0) {
                            if (colors[currentVal] == 1)
                                colors[n] = 2;
                            else
                                colors[n] = 1;
                            queue.add(n);
                        } else {
                            if (colors[n] == colors[currentVal]) return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
