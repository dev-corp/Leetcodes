class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                list.add(num);
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }
}

/*
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(memo.containsKey(nums1[i])){
                memo.put(nums1[i],memo.get(nums1[i])+1);
            }
            else {
                memo.put(nums1[i],1);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(memo.containsKey(nums2[i])){
                arr.add(nums2[i]);
                int value = memo.get(nums2[i])-1;
                if(value<=0){
                    memo.remove(nums2[i]);
                }
                else {
                    memo.put(nums2[i],value);
                }
            }
        }
        int[] result = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            result[i]=arr.get(i);
        }
        return result;
    }
}
*/