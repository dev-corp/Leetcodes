class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        return solve(0,0,m,n,grid,new HashMap<>());
    }
    private int solve(int cr,int cc,int m,int n,int[][] grid,HashMap<String,Integer> memo){
        if(cr>=m||cc>=n){
            return 999999;
        }
        if(cr==m-1&&cc==n-1){
            return grid[m-1][n-1];
        }
        String currentkey = cr+"_"+cc;
        if(memo.containsKey(currentkey)){
            return memo.get(currentkey);
        }
        int right = grid[cr][cc]+solve(cr+1,cc,m,n,grid,memo);
        int down = grid[cr][cc]+solve(cr,cc+1,m,n,grid,memo);
        memo.put(currentkey,Math.min(right,down));
        return Math.min(right,down);
    }
}