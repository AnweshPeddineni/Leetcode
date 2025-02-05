class Solution {
    public int[] getOrder(final int[][] tasks) {
        final int n = tasks.length;
        final int[][] ts = new int[n][3];

        for(int i = 0; i < n; ++i)
            ts[i] = new int[] { i, tasks[i][0], tasks[i][1] };

        Arrays.sort(ts, (a, b) -> a[1] - b[1]);

        final Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);

        final int[] result = new int[n];
        int i = 0, j = 0, time = 0;

        while(i < n) {
            while(j < n && ts[j][1] <= time)
                queue.offer(ts[j++]);

            if(queue.isEmpty()) {
                time = ts[j][1];
            } else {
                final int index = queue.peek()[0], enqueueTime = queue.peek()[1], processingTime = queue.poll()[2];

                time += processingTime;
                result[i++] = index;
            }
        }

        return result;
    }
}