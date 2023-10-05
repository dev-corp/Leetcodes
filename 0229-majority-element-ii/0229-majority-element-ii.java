class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> res = new ArrayList<>();
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
            if(e.getValue()>n/3){
                res.add(e.getKey());
            }
        }
        return res;
    }
}