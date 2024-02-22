class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        memo.put(0,1);
        int sum=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem = sum-k;
            if(memo.containsKey(rem)){
                ans+=memo.get(rem);
            }
            if(memo.containsKey(sum)){
                memo.put(sum,memo.get(sum)+1);
            }
            else {
                memo.put(sum,1);
            }
        }
        return ans;
    }
}