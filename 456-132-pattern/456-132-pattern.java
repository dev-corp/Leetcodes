class Solution
{
    public boolean find132pattern(int[] nums) 
    {
         int n = nums.length, top = n, third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) 
        {
            if (nums[i] < third) 
                return true;
            while (top < n && nums[i] > nums[top]) 
                third = nums[top++];
            nums[--top] = nums[i];
        }
    return false;
    }
}

//https://leetcode.com/problems/132-pattern/discuss/94089/Java-solutions-from-O(n3)-to-O(n)-for-%22132%22-pattern-(updated-with-one-pass-slution)