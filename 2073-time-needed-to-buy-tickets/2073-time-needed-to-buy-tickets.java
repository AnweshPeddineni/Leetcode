class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        Queue<int[]> queue = new LinkedList<>();

        int time = 0;

        for(int i=0; i<tickets.length; i++){
            int[] pair = new int[] {tickets[i], i};
            queue.offer(pair);
        }

        while(!queue.isEmpty()){
            int[] first = queue.poll();
            
            first[0]--;
            time++;

            if(first[0] == 0 && first[1] == k){
                break;
            }

            if(first[0] > 0){
                queue.offer(first);
            }

        }

        return time;
    }
}