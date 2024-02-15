class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        Set<Integer> intersection = new HashSet<>();
        for(int num : nums2){
            if(set.contains(num)){
                intersection.add(num);
            }
        }
        int[] result = new int[intersection.size()];
        int i = 0;
        for(int num : intersection){
            result[i++] = num;
        }
        return result;
    }
}

/*
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer,Boolean> memo = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(!memo.containsKey(nums1[i])){
                memo.put(nums1[i],true);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(memo.containsKey(nums2[i])){
                result.add(nums2[i]);
                memo.remove(nums2[i]);
            }
        }
        int[] ans = new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
        return ans;
    }
}
*/