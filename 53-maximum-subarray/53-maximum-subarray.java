class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        //int max_sum = 0;
        int max_sum = nums[0];
        int curr_sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            curr_sum = curr_sum + nums[i];
            if(curr_sum>max_sum)
                max_sum = curr_sum;
            if(curr_sum < 0)
                curr_sum = 0;
        }
        return max_sum;
    }
}


// class Solution 
// {
//     public int maxSubArray(int[] nums) 
//     {
//         //using kadane algorithm
//         int max_current = 0, max_global = nums[0];
//         for(int i = 0;i < nums.length - 1;i++ )
//         {
//             max_current = Math.max(nums[i], max_current + nums[i]);
//             if(max_current > max_global)
//                 max_global = max_current;
//         }
//         return max_global;
//     }
// }