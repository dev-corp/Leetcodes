class Solution {
    public int[] intersection(int[] arr, int[] arr1) {
        HashMap<Integer, Integer> index = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            if(index.containsKey(arr[i]))
            {
                int curr_val = index.get(arr[i]);
                index.put(arr[i],curr_val + 1);
            }
            else
                index.put(arr[i], 1);
        }
        for(int i=0; i<arr1.length; i++)
        {
            if(index.containsKey(arr1[i]) == true)
            {
                ans.add(arr1[i]);
                index.remove(arr1[i]);
            }
        }
        //int result[] = new int[ans.size()];
        //result.toArray(ans);
        int[] result = ans.stream().mapToInt(i->i).toArray();
        return result;
    }
}