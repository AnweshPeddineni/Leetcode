class Solution {
    public String convert(String s, int numRows) {
        // Edge Case: If numRows is 1 or greater than or equal to the string length, return s
        if(numRows == 1 || numRows >= s.length()){
            return s;
        }
        
        // Initialize an array of StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        
        // Iterate through each character in the string
        for(char c : s.toCharArray()){
            rows[currentRow].append(c);
            
            // Change direction if we hit the top or bottom row
            if(currentRow == 0 || currentRow == numRows - 1){
                goingDown = !goingDown;
            }
            
            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }
        
        // Combine all rows into one string
        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows){
            result.append(row);
        }
        
        return result.toString();
    }
}
