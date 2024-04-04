import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // The number of subarrays with exactly K distinct integers is the difference
        // between the number of subarrays with at most K distinct integers and
        // the number of subarrays with at most K-1 distinct integers
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            // If this is a new number, decrement k
            if (count.getOrDefault(nums[right], 0) == 0) {
                k--;
            }
            // Increment the count of this number
            count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);

            // If k is negative, move the left pointer
            while (k < 0) {
                int leftNum = nums[left++];
                count.put(leftNum, count.get(leftNum) - 1);
                if (count.get(leftNum) == 0) {
                    k++;
                }
            }

            // Add the number of subarrays that end at the current number
            result += right - left + 1;
        }

        return result;
    }
}