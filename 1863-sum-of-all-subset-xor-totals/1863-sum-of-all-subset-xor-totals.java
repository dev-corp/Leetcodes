class Solution {
    int solve(int[] nums,int ind,int xor)
    {
        if(ind>=nums.length) return xor;
        int x = solve(nums,ind+1,xor ^ nums[ind]);
        int y= solve(nums,ind+1,xor);
        return x + y;
    }
    public int subsetXORSum(int[] nums)
    {
        return solve(nums,0,0);
    }
}