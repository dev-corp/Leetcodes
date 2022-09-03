class Solution 
{
    public int rob(int[] nums) 
    {
        return maxMoney(nums, 0, new HashMap<Integer, Integer>());// 0 as the robber starts robbing from 0 index
    }
    
    public int maxMoney(int[] nums, int currentIndex, HashMap<Integer, Integer> memo)
    {
        if(currentIndex >= nums.length)
            return 0;
        
        int currentKey = currentIndex;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int rob = nums[currentIndex] + maxMoney(nums, currentIndex + 2, memo);
        int noRob = maxMoney(nums, currentIndex + 1, memo);
        
        memo.put(currentKey, Math.max(rob, noRob));
        return memo.get(currentKey);
    }
}