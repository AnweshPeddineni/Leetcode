class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];

        // **Initialize each character to be its own parent**
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // **Union operation: connect equivalent characters**
        for (int i = 0; i < s1.length(); i++) {
            union(parent, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder result = new StringBuilder();

        // **Build the result by finding the smallest equivalent character**
        for (char c : baseStr.toCharArray()) {
            char smallest = (char) (find(parent, c - 'a') + 'a');
            result.append(smallest);
        }

        return result.toString();
    }

    // **Find operation with path compression**
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    // **Union by keeping the lexicographically smaller character as root**
    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);

        if (px != py) {
            if (px < py) {
                parent[py] = px;
            } else {
                parent[px] = py;
            }
        }
    }
}



// Input: s1 = "parker", s2 = "morris", baseStr = "parser"

// (m,p), (a,o), (k,r,s), (e,i)   makkek