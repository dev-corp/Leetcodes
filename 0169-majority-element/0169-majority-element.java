class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int res = 0 ;
        HashMap<Integer,Integer> memo = new HashMap<>();
        for(int i=0;i<n;i++){
            if(memo.containsKey(nums[i])){
                int value = memo.get(nums[i]);
                memo.put(nums[i],value+1);
            }
            else {
                memo.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> e:memo.entrySet()){
            if(e.getValue()>n/2){
                res = e.getKey();
            }
        }
        return res;
    }
}