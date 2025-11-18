class Solution {

    // \U0001f7e2 I will greedily pick the most frequent available task using a max-heap
    // \U0001f7e2 I will use a queue to track tasks in cooldown with the time when they can run again
    // \U0001f7e2 I will simulate time steps until both the heap and cooldown queue are empty
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            // \U0001f7e2 No cooldown means we can execute tasks back-to-back
            return tasks.length;
        }

        int[] freq = new int[26];
        for (char task : tasks) {
            // \U0001f7e2 Count how many times each task appears
            freq[task - 'A']++;
        }

        // \U0001f7e2 Max-heap based on remaining frequency of tasks
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        // \U0001f7e2 Queue holds {remainingCount, readyTime}
        Queue<int[]> cooldownQueue = new LinkedList<>();

        int currentTime = 0;

        while (!maxHeap.isEmpty() || !cooldownQueue.isEmpty()) {
            currentTime++;

            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1; // \U0001f7e2 Execute one instance of the most frequent task
                if (remaining > 0) {
                    // \U0001f7e2 Put this task into cooldown until currentTime + n
                    cooldownQueue.offer(new int[]{remaining, currentTime + n});
                }
            }

            // \U0001f7e2 Move tasks whose cooldown has expired back into the heap
            if (!cooldownQueue.isEmpty() && cooldownQueue.peek()[1] == currentTime) {
                int[] readyTask = cooldownQueue.poll();
                maxHeap.offer(readyTask[0]);
            }
        }

        return currentTime;
    }
}



// tasks = ["A","A","A","B","B","B"], n = 2

// I am running the most frequent tasks first (max Heap) (based on frequency)

// once a task is completed I am going to add that to a cooling Queue (task, readyTime)

// when ever I complete a task I will reduce its frequency in freqMap

// 

// return time taken 