class Solution 
{
    public int findDuplicate(int[] nums) 
    {
        // Sorting the array first, then use a loop scanning from 1 to n
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++)
        {
            if (nums[i] == nums[i - 1])
            {
                return nums[i];
            }
        }

        return len;
    }
}


//         Using a HashSet to record the occurrence of each number.
//  Set<Integer> set = new HashSet<>();
//         int len = nums.length;
//         for (int i = 0; i < len; i++)
//         {
//             if (!set.add(nums[i]))
//             {
//                 return nums[i];
//             }
//         }

// return len;