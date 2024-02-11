class Solution {
    public int numTrees(int n) {
        return solve(n,new HashMap<>());
    }
    private int solve(int n,HashMap<Integer,Integer> memo){
        if(n==0||n==1){
            return 1;
        }
        int ways=0;
        for(int i=0;i<n;i++){
            ways+=solve(i,memo)*solve(n-i-1,memo);
        }
        return ways;
    }
}