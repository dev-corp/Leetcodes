class Solution 
{
    public int[] twoSum(int[] nums, int target)
    {
      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int sol[] = new int[2];
        
        for(int i = 0; i  < nums.length; i++)
        { 
		//check
            if(map.containsKey(target-nums[i]))
            {
            
                    sol[0]=i;
                    sol[1]= map.get(target-nums[i]);
                return sol;
            
            } 
            //insert
            map.put(nums[i], i);
        }
           
    return sol;
    }
}