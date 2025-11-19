class Solution {

    // \U0001f7e2 I will build the longest happy string using at most a 'a's, b 'b's, and c 'c's.
    // \U0001f7e2 I will use a max-heap to always choose the character with the highest remaining count.
    // \U0001f7e2 I will avoid adding a character if it creates three identical letters in a row.
    public String longestDiverseString(int a, int b, int c) {
        // \U0001f7e2 I will create a max-heap that stores (count, char) pairs.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (x, y) -> Integer.compare(y[0], x[0])
        );

        // \U0001f7e2 I will push each character with a positive count into the heap.
        if (a > 0) maxHeap.offer(new int[]{a, 'a'});
        if (b > 0) maxHeap.offer(new int[]{b, 'b'});
        if (c > 0) maxHeap.offer(new int[]{c, 'c'});

        // \U0001f7e2 I will use a StringBuilder to efficiently construct the final string.
        StringBuilder sb = new StringBuilder();

        // \U0001f7e2 I will repeat choosing characters until no valid choice remains.
        while (!maxHeap.isEmpty()) {
            // \U0001f7e2 I will take the character with the largest remaining count.
            int[] first = maxHeap.poll();
            int count1 = first[0];
            char ch1 = (char) first[1];

            // \U0001f7e2 I will check if adding ch1 would create three same letters in a row.
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 1) == ch1 && sb.charAt(len - 2) == ch1) {
                // \U0001f7e2 I will need to try the second-best character if available.
                if (maxHeap.isEmpty()) {
                    // \U0001f7e2 I will break because no safe character exists to add.
                    break;
                }

                // \U0001f7e2 I will take the next best character.
                int[] second = maxHeap.poll();
                int count2 = second[0];
                char ch2 = (char) second[1];

                // \U0001f7e2 I will append the second character instead to avoid three in a row.
                sb.append(ch2);
                // \U0001f7e2 I will decrease its count and push it back if there are more left.
                if (count2 - 1 > 0) {
                    maxHeap.offer(new int[]{count2 - 1, ch2});
                }

                // \U0001f7e2 I will push the first character back because I did not use it now.
                maxHeap.offer(first);
            } else {
                // \U0001f7e2 I will safely append ch1 because it does not form three in a row.
                sb.append(ch1);
                // \U0001f7e2 I will decrease its count and push it back if there are more left.
                if (count1 - 1 > 0) {
                    maxHeap.offer(new int[]{count1 - 1, ch1});
                }
            }
        }

        // \U0001f7e2 I will return the constructed longest happy string.
        return sb.toString();
    }
}
