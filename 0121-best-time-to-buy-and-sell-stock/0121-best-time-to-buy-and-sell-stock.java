class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        return solve(0,prices,n,1,1,new HashMap<>());
    }
    private int solve(int ci,int[] prices,int n,int canBuy,int transCount,HashMap<String,Integer> memo){
        if(transCount==0){
            return 0;
        }
        if(ci>=prices.length){
            return 0;
        }
        String currentkey=ci+"_"+canBuy+"_"+transCount;
        if(memo.containsKey(currentkey)){
            return memo.get(currentkey);
        }
        int idle = solve(ci+1,prices,n,canBuy,transCount,memo);
        int sell=0;
        if(canBuy==1){
            int buy = -prices[ci]+solve(ci+1,prices,n,0,transCount,memo);
            memo.put(currentkey,Math.max(idle,buy));
            return Math.max(idle,buy);
        } else {
            sell = prices[ci]+solve(ci+1,prices,n,1,0,memo);
            memo.put(currentkey,Math.max(idle,sell));
            return Math.max(idle,sell);
        }
    }
}