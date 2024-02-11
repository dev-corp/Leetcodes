class Solution 
{
    public int coinChange(int[] coins, int amount) 
    {
        // first we have to create a recurrsive call
        int ans = minCoins(coins, 0, amount, new HashMap<String, Integer>());// 0 indicates the staritng element of array or 1 coin
        if(ans == 100000)
        {
            return -1;// this has to be done for single coin not equating the amount
        }
        else
            return ans;
    }
    public int minCoins(int[] coins, int currentIndex, int amount, HashMap<String, Integer> memo)
    {
        if(amount == 0)
        {
            return 0;
        }
        
        if(currentIndex >=coins.length)
        {
            return 100000; //we are indirectly returning infinity for the invalid branch
        }
        
        String currentKey = Integer.toString(currentIndex) + "_" + Integer.toString(amount);
        
        if(memo.containsKey(currentKey))
        {
            return memo.get(currentKey);
        }
        int consider = 100000;// this handles the infinity branch single paths
        
        if(coins[currentIndex] <= amount)
        {
            consider = 1 + minCoins(coins, currentIndex, amount - coins[currentIndex], memo);
        }
        
        int nonConsider = minCoins(coins, currentIndex + 1, amount, memo);
        
        memo.put(currentKey, Math.min(consider, nonConsider));
        return memo.get(currentKey);
    }
}