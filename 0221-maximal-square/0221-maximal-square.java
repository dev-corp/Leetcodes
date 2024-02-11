class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int area=0;
        HashMap<String,Integer> memo = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    int sideLength = solve(i,j,m,n,matrix,memo);
                    area = Math.max(area,sideLength*sideLength);
                }
            }
        }
        return area;
    }
    private int solve(int cr,int cc,int m,int n,char[][] grid,HashMap<String,Integer> memo){
        if(cr>=m||cc>=n||grid[cr][cc]=='0'){
            return 0;
        }
        String currentkey = cr+"_"+cc;
        if(memo.containsKey(currentkey)){
            return memo.get(currentkey);
        }
        int right = 1+solve(cr,cc+1,m,n,grid,memo);
        int rightDown = 1+solve(cr+1,cc+1,m,n,grid,memo);
        int down = 1+solve(cr+1,cc,m,n,grid,memo);
        memo.put(currentkey,Math.min(right,Math.min(rightDown,down)));
        return Math.min(right,Math.min(rightDown,down));
    }
}