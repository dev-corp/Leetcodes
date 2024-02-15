class Solution { //  uses more space but doesn't require the input array to be sorted.
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(memo.containsKey(nums[i])){
                if((memo.get(nums[i])==2)){
                    continue;
                }
            else {
                memo.put(nums[i],memo.get(nums[i])+1);
                nums[j]=nums[i];
                j++;
            }
            } else {
                memo.put(nums[i],1);
                nums[j]=nums[i];
                j++;
            }
        } 
        int n=nums.length;
        int ans=j;
        while(j<n){
            nums[j]=0;
            j++;
        }
        return ans;
    }
}
// uses a HashMap to count the occurrences of each number. It iterates through the array, and for each number, it checks if it's already in the HashMap. If it is and its count is 2, it skips this number. If it is and its count is less than 2, it increments the count in the HashMap, replaces nums[j] with this number, and increments j. If it's not in the HashMap, it adds it to the HashMap with a count of 1, replaces nums[j] with this number, and increments j. After that, it sets the remaining elements in the array to 0. The time complexity is O(n) and the space complexity is O(n) due to the use of the HashMap.

//  more space-efficient and requires the input array to be sorted
/*
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;

        int i = 0;
        int count = 1;
        for(int j=i+1; j<nums.length; j++){
            if(count<2 && nums[i]==nums[j]){
                i++;
                count++;
                nums[i] = nums[j];
            }else if(nums[i] !=nums[j]){
                i++;
                count=1;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }
} 
*/
// uses two-pointer technique. It assumes that the input array is sorted. It uses two pointers, i and j, where i is the slow-runner and j is the fast-runner. The slow runner (i) is used to record the position to replace, and the fast runner (j) is used to scan through the array. The count variable is used to allow at most two duplicates. If the current number is the same as the previous one and count is less than 2, it increments i, count, and replaces nums[i] with nums[j]. If the current number is different from the previous one, it increments i, resets count to 1, and replaces nums[i] with nums[j]. The time complexity is O(n) and the space complexity is O(1).