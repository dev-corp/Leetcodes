class Solution {
    public int maxProfit(int[] prices, int fee) {
        return solve(0,prices,1,new HashMap<>(),fee);
    }
    private int solve(int ci,int[] prices,int canBuy,HashMap<String,Integer> memo,int fee){
        if(ci>=prices.length){
            return 0;
        }
        String currentkey = ci+"_"+canBuy;
        if(memo.containsKey(currentkey)){
            return memo.get(currentkey);
        }
        int idle = solve(ci+1,prices,canBuy,memo,fee);
        if(canBuy==1){
            int buy = -prices[ci]+solve(ci+1,prices,0,memo,fee);
            memo.put(currentkey,Math.max(idle,buy));
            return Math.max(idle,buy);
        }
        else {
            int sell = -fee+prices[ci]+solve(ci+1,prices,1,memo,fee);
            memo.put(currentkey,Math.max(idle,sell));
            return Math.max(idle,sell);
        }
    }
}