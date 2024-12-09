class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count the frequency of each word using a HashMap
        HashMap<String, Integer> fMap = new HashMap<>();
        for (String str : words) {
            fMap.put(str, fMap.getOrDefault(str, 0) + 1);
        }

        // Step 2: Define a priority queue (min-heap) with a custom comparator
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.frequency != b.frequency) {
                return a.frequency - b.frequency; // Ascending frequency
            }
            return b.word.compareTo(a.word); // Descending lexicographical order
        });

        // Step 3: Iterate over the frequency map and maintain a heap of size k
        for (String key : fMap.keySet()) {
            Pair currentPair = new Pair(key, fMap.get(key));
            minHeap.offer(currentPair);

            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent or lexicographically larger word
            }
        }

        // Step 4: Extract elements from the heap into a list
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().word);
        }

        // Step 5: Reverse to have the highest frequency first and correct lex order
        Collections.reverse(result);
        return result;
    }

    // Pair class to hold word and its frequency
    static class Pair {
        int frequency;
        String word;

        public Pair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

    }
}