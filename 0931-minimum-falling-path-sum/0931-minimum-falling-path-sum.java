class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int result = 999999;
        for(int i=0;i<n;i++){
            result = Math.min(result,solve(0,i,m,n,matrix,new HashMap<>()));
        }
        return result;
    }
    private int solve(int cr,int cc,int m,int n,int[][] grid,HashMap<String,Integer> memo){
        if(cr>=m||cc>=n||cc<0||cr<0){
            return 999999;
        }
        if(cr==m-1){
            return grid[cr][cc];
        }
        String currentkey = cr+"_"+cc;
        if(memo.containsKey(currentkey)){
            return memo.get(currentkey);
        }
        int down = grid[cr][cc]+solve(cr+1,cc,m,n,grid,memo);
        int diaright = grid[cr][cc]+solve(cr+1,cc+1,m,n,grid,memo);
        int dialeft = grid[cr][cc]+solve(cr+1,cc-1,m,n,grid,memo);
        memo.put(currentkey,Math.min(down,Math.min(dialeft,diaright)));
        return Math.min(down,Math.min(diaright,dialeft));
    }
}