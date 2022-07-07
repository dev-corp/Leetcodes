class Solution
{
    public int majorityElement(int[] nums)
    {
        HashMap<Integer, Integer> ans = new HashMap<Integer, Integer>();
        int max = 0, key = nums[new Random().nextInt(nums.length)];
        for(int i=0;i<nums.length;i++)
        {
            if(ans.containsKey(nums[i]))
            {
                int temp = ans.get(nums[i]);
                ans.put(nums[i], temp+1);
                if(max<temp)
                {
                    max = temp;
                    key = nums[i];
                }
                    
            }
            else
                ans.put(nums[i], 1);
        }
        return key;
    }
}

//                      Only use when we need to find the largest ket in a Hashmap as TreeMap
// TreeMap<Integer, Integer> ans = new TreeMap<Integer, Integer>();
//         for(int i=0;i<nums.length;i++)
//         {
//             if(ans.containsKey(nums[i]))
//             {
//                 int temp = ans.get(nums[i]);
//                 ans.put(nums[i], temp+1);
//             }
//             else
//                 ans.put(nums[i], 1);
//         }
//         return ans.lastEntry().getKey();
//         //////////////s.substring(s.lastIndexOf("/") + 1)