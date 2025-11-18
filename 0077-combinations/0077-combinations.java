class Solution {
    public List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();;
        dfs(1, combination, n, k);
        return result;
    }
    
    public void dfs(int start,
                    List<Integer> comb,
                    int n,
                    int k){

        if(comb.size() > k) return;

        if(comb.size()==k){
            result.add(new ArrayList<>(comb));
            return;
        }

        // if (start > n) {
        //     return;
        // }

        for(int i=start; i<=n; i++){
           comb.add(i);
           dfs(i+1, comb, n, k);
           comb.remove(comb.size()-1);
        }
    }
}


// n = 4, k = 2 (1 to n)

// arr[] = [1,2,3,4]
// all k size combinations -> [1,2],[1,3],[1,4],[2,3],[2,4],[3,4]

// dfs(start pointer, curr combination, k, n)

// recursive back tracking -> to produe all combinations n*(2)^k
// space -> n*2^k for result and k for recursion stack