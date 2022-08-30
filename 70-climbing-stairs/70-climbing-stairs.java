class Solution 
{
    public int climbStairs(int n)
    {
        return totalWays(0,n,new HashMap<Integer,Integer>());
    }
    
    
    public int totalWays(int currentStair,int targetStair,HashMap<Integer,Integer> memo)
    {
        if(currentStair > targetStair)
            return 0;
        if(currentStair == targetStair)
            return 1;
        
        int currentKey = currentStair;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int oneStep = totalWays(currentStair+1,targetStair,memo);
        int twoStep = totalWays(currentStair+2,targetStair,memo);
        
        memo.put(currentKey,oneStep+twoStep);
        
        return oneStep + twoStep;
    }
}

// At every stairs we have 2 options
// 1 option 1 steps
// 2 option 2 steps
// once we reach to the target stairs we will return 1

// to convert the recurrsive to dynamic programming look at the paramaters that are getting changed in the recurrsive call.
// The parameters which are getting changed we will store them as a Hashmap for faster retrival of the already stored answer, else we store the current answer.

// In the current program we will initilize hashmap form where we call the method