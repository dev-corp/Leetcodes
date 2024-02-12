class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                nums[j]=nums[i];
                j++;
                map.put(nums[i],1);
            }
        }
        return j;
    }
}