class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr == null){
            return false; // or throw new IllegalArgumentException("Input array cannot be null");
        }
        HashMap<Integer,Integer> memo = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(memo.containsKey(arr[i])){
                memo.put(arr[i],memo.get(arr[i])+1);
            }
            else {
                memo.put(arr[i],1);
            }
        }
        HashMap<Integer,Integer> memo2 = new HashMap<>();
        for(Map.Entry<Integer,Integer> e:memo.entrySet()){
            if(memo2.containsKey(e.getValue())){
                return false;
            }
            else {
                memo2.put(e.getValue(),1);
            }
        }
        return true;
    }
}