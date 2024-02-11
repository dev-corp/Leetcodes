class Solution {
    public int change(int amount, int[] coins) {
        return solve(0,amount,coins,new HashMap<>());
    }
    private int solve(int ci,int amount,int[] coins,HashMap<String,Integer> memo){
        if(amount==0){
            return 1;
        }
        if(ci>=coins.length){
            return 0;
        }
        String currentkey = ci+"_"+amount;
        if(memo.containsKey(currentkey)){
            return memo.get(currentkey);
        }
        int consider = 0;
        if(amount>=coins[ci]){
            consider = solve(ci,amount-coins[ci],coins,memo);
        }
        int notconsider = solve(ci+1,amount,coins,memo);
        memo.put(currentkey,consider+notconsider);
        return consider + notconsider;
    }
}