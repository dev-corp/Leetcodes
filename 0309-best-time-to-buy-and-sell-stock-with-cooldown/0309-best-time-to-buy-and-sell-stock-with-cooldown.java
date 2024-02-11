class Solution {
    public int maxProfit(int[] prices) {
        return solve(0,prices,1,new HashMap<>());
    }
    private int solve(int ci,int[] prices,int canBuy,HashMap<String,Integer> memo){
        if(ci>=prices.length){
            return 0;
        }
        String currentkey = ci+"_"+canBuy;
        if(memo.containsKey(currentkey)){
            return memo.get(currentkey);
        }
        int idle = solve(ci+1,prices,canBuy,memo);
        if(canBuy==1){
            int buy = -prices[ci]+solve(ci+1,prices,0,memo);
            memo.put(currentkey,Math.max(idle,buy));
            return Math.max(idle,buy);
        }
        else {
            int sell = prices[ci]+solve(ci+2,prices,1,memo);
            memo.put(currentkey,Math.max(idle,sell));
            return Math.max(idle,sell);
        }
    }
}