class Solution {
    int c=(int)(Math.pow(10,9))+7;
    public int numRollsToTarget(int d, int f, int target) {
        
        int memo[][] = new int[31][1001];
        
        for(int i=0;i<d+1;i++){
            for(int j=0;j<target+1;j++){
                memo[i][j]=-1;
            }
        }
        return totalDice(d,f,target,memo)%c;
    }
    
   
    public int totalDice(int dices,int faces,int target,int memo[][]){
        
        if((dices<=0 || target<0) && target!=0)
            return 0;
        
        if(dices==0 && target==0)
            return 1;
        
        if(memo[dices][target]!=-1)
            return memo[dices][target];
        int ans=0;
        for(int i=1;i<=faces;i++){
            
            int a=totalDice(dices-1,faces,target-i,memo);
            ans=(ans%c+a%c)%c;
            
        }    
        
        return memo[dices][target]=ans%c;
    }
}