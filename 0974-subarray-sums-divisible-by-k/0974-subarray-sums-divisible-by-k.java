class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        int prefixSum=0;
        int ans=0;
        memo.put(prefixSum,1);
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int currentRem = ((prefixSum%k)+k)%k;
            if(memo.containsKey(currentRem)){
                ans+=memo.get(currentRem);
                memo.put(currentRem,memo.get(currentRem)+1);
            }
            else {
                memo.put(currentRem,1);
            }
        }
        return ans;
    }
}