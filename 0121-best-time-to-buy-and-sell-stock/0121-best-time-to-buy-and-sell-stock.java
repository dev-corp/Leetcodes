class Solution {
    public int maxProfit(int[] prices) {
        return solve(0,prices,1,1,new HashMap<String,Integer>());
    }
    private int solve(int ci,int[] prices,int canBuy,int transCount,HashMap<String,Integer> memo){
        if(ci>=prices.length||transCount==0){
            return 0;
        }
        String currentKey = ci+"_"+canBuy+"_"+transCount;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        int idle = solve(ci+1,prices,canBuy,transCount,memo);
        if(canBuy==1){
            int buy = -prices[ci]+solve(ci+1,prices,1-canBuy,transCount,memo);
            memo.put(currentKey,Math.max(idle,buy));
            return Math.max(idle,buy);
        }
        else {
            int sell = prices[ci]+solve(ci+1,prices,canBuy,0,memo);
            memo.put(currentKey,Math.max(idle,sell));
            return Math.max(idle,sell);
        }
    }
}