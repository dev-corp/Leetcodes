import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Initialize an empty list to store the duplicate numbers
        List<Integer> duplicates = new ArrayList<>();

        // Iterate over each number in the array
        for (int num : nums) {
            // Calculate the absolute value of the number
            // because numbers might have been negated in previous iterations
            int absNum = Math.abs(num);

            // If the number at the index absNum-1 in the array is negative,
            // that means the number absNum has been seen before, so it's a duplicate
            if (nums[absNum - 1] < 0) {
                duplicates.add(absNum);
            } else {
                // If the number at the index absNum-1 is not negative,
                // negate the number to mark it as seen
                nums[absNum - 1] = -nums[absNum - 1];
            }
        }

        // Return the list of duplicates
        return duplicates;
    }
}