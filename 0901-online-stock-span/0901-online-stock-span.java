class StockSpanner {
   // monotonic decreasing stack (stores price and span as pairs).
   private Stack<int[]> stack; // Stores [price, span]

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1; // Minimum span for today is 1
        
        // Pop elements while the previous price is <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // Add their spans to today
        }

        // Push current price and calculated span
        stack.push(new int[]{price, span});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */