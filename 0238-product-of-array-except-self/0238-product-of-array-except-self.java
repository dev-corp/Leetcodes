class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
        int countOfZeros = 0; // count the number of zeros in the array
        int productOfNonZeros = 1; // product of all non-zero numbers

        // Calculate the product of non-zero numbers and count zeros
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0) 
                countOfZeros++;
            else 
                productOfNonZeros *= nums[i];
        }

        // If there are more than one zeros, all numbers in the output will be zero
        if(countOfZeros > 1)
        {
            Arrays.fill(nums, 0);
        }
        // If there is exactly one zero, all positions in the output array should be zero except the position of the zero
        else if(countOfZeros == 1)
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(nums[i] == 0) 
                    nums[i] = productOfNonZeros; // replace zero with the product of non-zero numbers
                else 
                    nums[i] = 0; // replace non-zero numbers with zero
            }
        }
        // If there are no zeros, each number in the output array should be the product of all numbers divided by the number at that position
        else
        {
            for(int i = 0; i < nums.length; i++) 
                nums[i] = productOfNonZeros / nums[i];
        }

        return nums;
    }
}