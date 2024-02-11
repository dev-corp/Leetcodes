class Solution {
    public int uniquePaths(int m, int n) {
        return solve(0,0,m,n,new HashMap<>());
    }
    private int solve(int cr,int cc,int m,int n,HashMap<String,Integer> memo){
        if(cr==m-1&&cc==n-1){
            return 1;
        }
        if(cr>=m||cc>=n){
            return 0;
        }

        String currentkey = cr+"_"+cc;
        if(memo.containsKey(currentkey)){
            return memo.get(currentkey);
        }

        int right = solve(cr+1,cc,m,n,memo);
        int down = solve(cr,cc+1,m,n,memo);
        memo.put(currentkey,right+down);
        return right + down;
    }
}