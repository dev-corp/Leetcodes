class Solution {
    public int findPeakElement(int[] nums)
    {
        int max_num=Integer.MIN_VALUE,index=0;
        for(int i=0;i<nums.length;i++)
        {
            if(max_num<nums[i])
            {
                max_num=nums[i];
                index=i;
            }
        }
        return index;
    }
}