class Solution {
    public int maxProfit(int[] prices) {
        return solve(0,prices,1,2,new HashMap<>());
    }
    private int solve(int ci,int[] prices,int canBuy,int transCount,HashMap<String,Integer> memo){
        if(ci>=prices.length||transCount==0){
            return 0;
        }
        String currentkey = ci+"_"+canBuy+"_"+transCount;
        if(memo.containsKey(currentkey)){
            return memo.get(currentkey);
        }
        int idle = solve(ci+1,prices,canBuy,transCount,memo);
        if(canBuy==1){
            int buy = -prices[ci]+solve(ci+1,prices,0,transCount,memo);
            memo.put(currentkey,Math.max(idle,buy));
            return Math.max(idle,buy);
        }
        else {
            int sell = prices[ci]+solve(ci+1,prices,1,transCount-1,memo);
            memo.put(currentkey,Math.max(idle,sell));
            return Math.max(idle,sell);
        }
    }
}