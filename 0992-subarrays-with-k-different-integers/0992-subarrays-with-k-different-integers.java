class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return solve(nums,k)-solve(nums,k-1);
    }
    private int solve(int[] nums,int k){
        if(k==0){
            return 0;
        }
        HashMap<Integer,Integer> memo = new HashMap<>();
        int release=0;
        int ans=0;
        int distinct=0;
        for(int acquire=0;acquire<nums.length;acquire++){
            if(memo.containsKey(nums[acquire])){
                memo.put(nums[acquire],memo.get(nums[acquire])+1);
            }
            else {
                distinct+=1;
                memo.put(nums[acquire],1);
            }
        
        while(release<acquire&&distinct>k){
            int discard = nums[release];
            release+=1;
            memo.put(discard,memo.get(discard)-1);
            if(memo.get(discard)==0){
                memo.remove(discard);
                distinct-=1;
            }
        }
        ans+=acquire-release+1;
        }
        return ans;
    }
}