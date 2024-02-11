class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        return solve(0,0,m,n,obstacleGrid,new HashMap<>());
    }
    private int solve(int cr,int cc,int m,int n,int[][] grid,HashMap<String,Integer> memo){
        if(cr>=m||cc>=n||grid[cr][cc]==1){
            return 0;
        }
        if(cr==m-1&&cc==n-1){
            return 1;
        }
        String currentkey = cr+"_"+cc;
        if(memo.containsKey(currentkey)){
            return memo.get(currentkey);
        }
        
        int right = solve(cr+1,cc,m,n,grid,memo);
        int down = solve(cr,cc+1,m,n,grid,memo);
        memo.put(currentkey,right+down);
        return right+down;
    }
}