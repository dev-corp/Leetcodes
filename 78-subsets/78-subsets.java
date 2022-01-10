class Solution 
{
    public List<List<Integer>> subsets(int[] nums)
    {
           List<List<Integer>> list=new ArrayList<List<Integer>>();
        
        
     BackTrack(list,nums,new ArrayList<>(),0);
        
        return list;
    }
        public void BackTrack(List<List<Integer>> list, int[] nums, List<Integer> arr, int index)
        {
            list.add(new ArrayList<>(arr));

            for(int i = index; i < nums.length; i++)
            {
                arr.add(nums[i]);
                BackTrack(list, nums, arr, i + 1);
                arr.remove(arr.size() - 1);
            }
        }
}
